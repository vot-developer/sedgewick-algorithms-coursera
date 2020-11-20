package org.sedgewick.algorithms.part_one.week_two.question_two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackWithMaxTest {

    @Test
    void getMax() {
        StackWithMax stack = new StackWithMax();
        stack.push(1);
        stack.push(0);
        stack.push(3);
        assertEquals(3, stack.getMax());
        assertEquals(3, stack.pop());
        assertEquals(1, stack.getMax());
        assertEquals(0, stack.top());
    }
}