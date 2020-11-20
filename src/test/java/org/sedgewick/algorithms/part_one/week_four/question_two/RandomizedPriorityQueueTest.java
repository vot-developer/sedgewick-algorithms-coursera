package org.sedgewick.algorithms.part_one.week_four.question_two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomizedPriorityQueueTest {

    @Test
    void test() {
        RandomizedPriorityQueue<Integer> q = new RandomizedPriorityQueue<>(10);
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.delRandom();
        q.delRandom();
        q.delRandom();
        assertTrue(q.isEmpty());
    }
}