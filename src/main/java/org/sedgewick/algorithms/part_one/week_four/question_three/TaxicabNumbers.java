package org.sedgewick.algorithms.part_one.week_four.question_three;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaxicabNumbers {

    class Candidates implements Comparable<Candidates> {
        final int a;
        final int b;
        final int sum;

        public Candidates(int a, int b) {
            this.a = a;
            this.b = b;
            this.sum = (int) (Math.pow(a, 3) + Math.pow(b, 3));
        }

        @Override
        public int compareTo(Candidates o) {
            if (sum > o.sum) return 1;
            if (sum < o.sum) return -1;
            return 0;
        }
    }

    public List<List<Integer>> find(int max) {
        List<List<Integer>> result = new ArrayList<>();
        if (max <= 1) return result;

        MinPQ<Candidates> minPQ = new MinPQ<>();

        for (int i = 1; i < max; i++)
            minPQ.insert(new Candidates(i, i));

        while (minPQ.size() > 1) {
            Candidates c = minPQ.delMin();
            if (c.sum == minPQ.min().sum)
                result.add(Arrays.asList(c.a, c.b, minPQ.min().a, minPQ.min().b));

            if (c.b < max)
                minPQ.insert(new Candidates(c.a, c.b + 1)); // try to fit in O(n), use only n size and increase second value for all combinations
        }
        return result;
    }

}
