package org.sedgewick.algorithms.part_one.week_two.question_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TwoStackQueueTest {

    @Test
    void test() {
        TwoStackQueue queue = new TwoStackQueue();
        queue.push(1);
        queue.push(2);
        assertEquals(1, queue.peek());
        assertEquals(1, queue.pop());
        assertFalse(queue.empty());
    }
}