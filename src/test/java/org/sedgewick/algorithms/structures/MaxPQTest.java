package org.sedgewick.algorithms.structures;

import org.junit.jupiter.api.Test;
import org.sedgewick.algorithms.structures.MaxPQ;

import static org.junit.jupiter.api.Assertions.*;

class MaxPQTest {

    @Test
    void isEmpty() {
        MaxPQ<Integer> pq = new MaxPQ<>(10);
        pq.insert(1);
        assertEquals(1, pq.delete());
        assertTrue(pq.isEmpty());
    }

    @Test
    void test() {
        MaxPQ<Integer> pq = new MaxPQ<>(10);
        pq.insert(7);
        pq.insert(2);
        pq.insert(11);
        pq.insert(6);
        assertEquals(11, pq.delete());
        assertEquals(7, pq.delete());
        assertEquals(6, pq.delete());
        assertEquals(2, pq.delete());
    }
}