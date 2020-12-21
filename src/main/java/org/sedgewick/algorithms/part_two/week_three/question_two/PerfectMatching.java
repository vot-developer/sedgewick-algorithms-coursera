package org.sedgewick.algorithms.part_two.week_three.question_two;

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FordFulkerson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PerfectMatching {
    private final int n;
    private final int k;
    private final FlowNetwork flowNetwork;
    private final Random random;

    public PerfectMatching(int n, int k) {
        this.n = n;
        this.k = k;
        this.flowNetwork = new FlowNetwork(2 * n + 2); // n men, w women + s (0) + t (2n + 1)
        this.random = new Random();
    }

    public boolean isArrange() {
        List<Woman> allWomen = new ArrayList<>();
        for (int i = 2; i <= 2 * n; i += 2) {
            allWomen.add(new Woman(i));
        }

        for (int i = 1; i <= 2 * n; i++) {
            if (i % 2 != 0) {  // odd - men
                flowNetwork.addEdge(new FlowEdge(0, i, 1));
                Set<Integer> knownWomen = getRandomWomen(allWomen);
                for (int j : knownWomen)
                    flowNetwork.addEdge(new FlowEdge(i, j, Double.POSITIVE_INFINITY));
            } else { // even - women
                flowNetwork.addEdge(new FlowEdge(i, 2 * n + 1, 1));
            }
        }

        FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, 0, 2 * n + 1);
        return fordFulkerson.value() == n;
    }

    private Set<Integer> getRandomWomen(List<Woman> allWomen) {
        Set<Integer> result = new HashSet<>(k);
        int i;
        while (result.size() < k && allWomen.size() > 0) {
            i = random.nextInt(allWomen.size());
            Woman w = findWomanWithLessFriends(allWomen, i);
            if (w.countKnowMen < k && !result.contains(w.vertex)) {
                result.add(w.vertex);
                w.countKnowMen++;
            }
        }
        return result;
    }

    private Woman findWomanWithLessFriends(List<Woman> allWomen, int i){
        // prevent situation when all men friends of one woman.
        Woman w = allWomen.get(i);
        int count = w.countKnowMen;
        for (int j = 0; j < allWomen.size(); j++) {
            if (allWomen.get(j).countKnowMen == k) {
                allWomen.remove(j);
                continue;
            }
            if (allWomen.get(j).countKnowMen < count)
                w = allWomen.get(j);
        }
        return w;
    }

    private class Woman {
        int vertex;
        int countKnowMen;

        public Woman(int vertex) {
            this.vertex = vertex;
            this.countKnowMen = 0;
        }
    }
}
