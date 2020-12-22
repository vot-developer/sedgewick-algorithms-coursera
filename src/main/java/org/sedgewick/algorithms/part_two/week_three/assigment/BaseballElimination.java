package org.sedgewick.algorithms.part_two.week_three.assigment;

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FordFulkerson;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseballElimination {
    private final int size;
    private final int[] w;
    private final int[] l;
    private final int[] r;
    private final int[][] g;
    private final Map<String, Integer> teamToId;
    private final Map<Integer, String> idToTeam;
    private final Map<Integer, List<String>> eliminates;

    // create a baseball division from given filename in format specified below
    public BaseballElimination(String filename) {
        In in = new In(filename);
        this.size = in.readInt();
        this.teamToId = new HashMap<>(size);
        this.idToTeam = new HashMap<>(size);
        this.w = new int[size];
        this.l = new int[size];
        this.r = new int[size];
        this.g = new int[size][size];
        this.eliminates = new HashMap<>(size);
        for (int i = 0; i < size; i++)
            eliminates.put(i, new ArrayList<>());

        for (int i = 0; i < size; i++) {
            String team = in.readString();
            teamToId.put(team, i);
            idToTeam.put(i, team);
            w[i] = in.readInt();
            l[i] = in.readInt();
            r[i] = in.readInt();

            for (int j = 0; j < size; j++)
                this.g[i][j] = in.readInt();
        }

        for (int i = 0; i < size; i++)
            calculateElimination(i);
    }

    private void calculateElimination(int id) {
        //simple elimination
        Set<Integer> earlyEliminations = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (i == id) continue;
            if (w[id] + r[id] < w[i]) {
                eliminates.get(id).add(idToTeam.get(i));
                earlyEliminations.add(i);
            }
        }

        int s = size, t = size + 1;
        int countPairs = (size - earlyEliminations.size() - 1) * (size - earlyEliminations.size() - 2) / 2;
        int pairId = size + 2;
        FlowNetwork flowNetwork = new FlowNetwork(size + 2 + countPairs);
        // teams
        for (int v = 0; v < size; v++) {
            if (v == id || earlyEliminations.contains(v)) continue;
            flowNetwork.addEdge(new FlowEdge(v, t, w[id] + r[id] - w[v]));
        }

        // games
        for (int i = 0; i < size - earlyEliminations.size(); i++)
            for (int j = i + 1; j < size - earlyEliminations.size(); j++) {
                if (i == id || j == id || earlyEliminations.contains(i) || earlyEliminations.contains(j)) continue;
                flowNetwork.addEdge(new FlowEdge(s, pairId, g[i][j]));
                flowNetwork.addEdge(new FlowEdge(pairId, i, Double.POSITIVE_INFINITY));
                flowNetwork.addEdge(new FlowEdge(pairId, j, Double.POSITIVE_INFINITY));
                pairId++;
            }

        FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, s, t);
        for (int v = 0; v < size; v++)
            if (fordFulkerson.inCut(v))
                eliminates.get(id).add(idToTeam.get(v));
    }

    // number of teams
    public int numberOfTeams() {
        return size;
    }

    // all teams
    public Iterable<String> teams() {
        return teamToId.keySet();
    }

    // number of wins for given team
    public int wins(String team) {
        validate(team);
        return w[teamToId.get(team)];
    }

    // number of losses for given team
    public int losses(String team) {
        validate(team);
        return l[teamToId.get(team)];
    }

    // number of remaining games for given team
    public int remaining(String team) {
        validate(team);
        return r[teamToId.get(team)];
    }

    // number of remaining games between team1 and team2
    public int against(String team1, String team2) {
        validate(team1);
        validate(team2);
        return g[teamToId.get(team1)][teamToId.get(team2)];
    }

    // is given team eliminated?
    public boolean isEliminated(String team) {
        validate(team);
        return !eliminates.get(teamToId.get(team)).isEmpty();
    }

    // subset R of teams that eliminates given team; null if not eliminated
    public Iterable<String> certificateOfElimination(String team) {
        validate(team);
        return eliminates.get(teamToId.get(team)).isEmpty() ? null : eliminates.get(teamToId.get(team));
    }

    private void validate(String arg) {
        if (arg == null || !teamToId.containsKey(arg))
            throw new IllegalArgumentException("invalid team");
    }

    public static void main(String[] args) {
        BaseballElimination division = new BaseballElimination(args[0]);
        for (String team : division.teams()) {
            if (division.isEliminated(team)) {
                StdOut.print(team + " is eliminated by the subset R = { ");
                for (String t : division.certificateOfElimination(team)) {
                    StdOut.print(t + " ");
                }
                StdOut.println("}");
            } else {
                StdOut.println(team + " is not eliminated");
            }
        }
    }
}
