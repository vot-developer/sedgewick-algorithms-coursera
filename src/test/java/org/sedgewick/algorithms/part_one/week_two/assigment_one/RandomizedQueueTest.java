package org.sedgewick.algorithms.part_one.week_two.assigment_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedQueueTest {

    @Test
    void enqueue() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        for (int i = 0; i < 100; i ++)
            queue.enqueue(i);

        for (int i = 0; i < 90; i ++)
            queue.dequeue();

        for (Integer i : queue){
            System.out.println(i);
        }
//        System.out.println(queue.sample());
//        System.out.println(queue.sample());
//        System.out.println("==========================");
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
    }
}