package org.sedgewick.algorithms.part_one.week_two.assigment_one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<>();

        int count = 0;
        for (; count < k; count++) queue.enqueue(StdIn.readString());

        while (!StdIn.isEmpty()) {
            String data = StdIn.readString();
            if (StdRandom.uniform(++count) < k) {
                queue.dequeue();
                queue.enqueue(data);
            }
        }

        for (String item : queue) StdOut.println(item);
    }
}
