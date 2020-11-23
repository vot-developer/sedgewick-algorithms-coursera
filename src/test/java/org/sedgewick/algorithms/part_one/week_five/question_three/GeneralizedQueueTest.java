package org.sedgewick.algorithms.part_one.week_five.question_three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneralizedQueueTest {
    @Test
    void testQueue() {
        GeneralizedQueue<Integer> queue = new GeneralizedQueue<>();
        queue.push(1);
        queue.push(2);
        assertEquals(1, queue.peek());
        assertEquals(1, queue.pop());
        assertFalse(queue.empty());
        assertEquals(2, queue.pop());
    }

    @Test
    void testIndex() {
        GeneralizedQueue<Integer> queue = new GeneralizedQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        assertEquals(1, queue.get(1));
        assertEquals(3, queue.get(3));
        queue.remove(3);
        assertEquals(4, queue.get(3));
        queue.remove(1);
        queue.remove(1);
        queue.remove(1);
        assertTrue(queue.empty());
    }
}