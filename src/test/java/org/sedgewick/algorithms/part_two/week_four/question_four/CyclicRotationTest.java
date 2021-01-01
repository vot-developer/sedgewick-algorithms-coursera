package org.sedgewick.algorithms.part_two.week_four.question_four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CyclicRotationTest {

    @Test
    void isCyclicRotation() {
        CyclicRotation cr = new CyclicRotation();
        assertTrue(cr.isCyclicRotation("winterbreak", "breakwinter"));
        assertTrue(cr.isCyclicRotation("breakwinter", "winterbreak"));
    }

    @Test
    void isNotCyclicRotation() {
        CyclicRotation cr = new CyclicRotation();
        assertFalse(cr.isCyclicRotation("winterbreak", "reakbwinter"));
    }
}