package org.sedgewick.algorithms.part_one.week_four.question_three;

import edu.princeton.cs.algs4.MaxPQ;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaxicabNumbers {

    class Candidates implements Comparable<Candidates>{
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

    public List<List<Integer>> find(int max){
        List<List<Integer>> result = new ArrayList<>();
        if (max <= 1) return result;

        MaxPQ<Candidates> maxPQ = new MaxPQ<>();

        for (int i = 1; i < max; i++)
            for (int j = i + 1; j < max; j++)
                maxPQ.insert(new Candidates(i, j));

        List<Candidates> lr = new ArrayList<>();
        while(maxPQ.size() > 1){
            Candidates c = maxPQ.delMax();
            if (c.sum == maxPQ.max().sum){
                lr.add(c);
                while(c.sum == maxPQ.max().sum){
                    c = maxPQ.delMax();
                    lr.add(c);
                }
                for (int i = 0; i < lr.size(); i++)
                    for (int j = i + 1; j < lr.size(); j++)
                        result.add(Arrays.asList(lr.get(i).a, lr.get(i).b, lr.get(j).a, lr.get(j).b));
            }
            lr.clear();
        }

        return result;
    }

}
