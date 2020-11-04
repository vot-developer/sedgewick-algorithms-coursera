package org.sedgewick.algorithms.part_one.week_one.question_three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuccessorTest {

    @Test
    void delete() {
        Successor s = new Successor(10);
        s.delete(1);
        s.delete(3);
        s.delete(2);
        assertEquals(4, s.findSuccessor(1));
        s.delete(4);
        assertEquals(5, s.findSuccessor(2));
        assertEquals(6, s.findSuccessor(6));
    }
}