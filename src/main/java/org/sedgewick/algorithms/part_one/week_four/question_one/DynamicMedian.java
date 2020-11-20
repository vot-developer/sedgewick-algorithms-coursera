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
        if (min.size() == 0) {
            min.insert(value);
            return;
        }

        if (min.size() > 0 && max.size() == 0) {
            max.insert(value);
            return;
        }

        if (value < min.max()) {
            if (min.size() > max.size()) max.insert(min.delMax());
            min.insert(value);
        } else if (value > max.min()) {
            if (max.size() > min.size()) min.insert(max.delMin());
            max.insert(value);
        } else {
            if (min.size() > max.size()) max.insert(value);
            else min.size();
        }
    }

    public int median() {
        if (min.size() == 0) throw new NoSuchElementException();
        if (max.size() > min.size()) return max.min();
        return min.max();
    }

    public int removeMedian() {
        int result = 0;
        if (max.size() > min.size()) {
            result = max.delMin();
            if (max.size() > min.size()) min.insert(max.delMin());
            return result;
        }

        result = min.delMax();
        if (min.size() > max.size()) max.insert(min.delMax());

        return result;
    }
}
