package org.sedgewick.algorithms.part_one.week_four.question_one;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;

import java.util.NoSuchElementException;

public class DynamicMedian {
    private MinPQ<Integer> max;
    private MaxPQ<Integer> min;

    public DynamicMedian(int size) {
        max = new MinPQ<>(size / 2 + 1);
        min = new MaxPQ<>(size / 2 + 1);
    }

    public void insert(int value) {
        min.insert(value);
        max.insert(min.delMax());
        if (min.size() < max.size())
            min.insert(max.delMin());
    }

    public double median() {
        if (min.size() == 0) throw new NoSuchElementException();
        if (max.size() > min.size()) return max.min();
        return min.max();
    }

    public int removeMedian() {
        int result = min.delMax();
        if (max.size() > min.size())
            min.insert(max.delMin());
        return result;
    }
}
