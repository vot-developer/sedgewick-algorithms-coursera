package org.sedgewick.algorithms.part_one.week_four.question_two;

import org.sedgewick.algorithms.structures.MaxPQ;

import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedPriorityQueue<Key extends Comparable<Key>> extends MaxPQ<Key> {
    private final Random random;

    public RandomizedPriorityQueue(int size) {
        super(size);
        random = new Random();
    }

    public Key sample(){
        if (super.size == 0) throw new NoSuchElementException();
        return values[random.nextInt(size) + 1]; // +1 because index 0 - doesn't save value
    }

    public Key delRandom(){
        if (super.size == 0) throw new NoSuchElementException();
        int i = random.nextInt(size) + 1;
        swap(i, size);
        Key result = values[size];
        values[size--] = null;
        down(i);
        return result;
    }
}
