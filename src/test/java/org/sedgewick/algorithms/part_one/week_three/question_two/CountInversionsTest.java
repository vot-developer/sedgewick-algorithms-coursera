package org.sedgewick.algorithms.part_one.week_three.question_two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountInversionsTest {

    @Test
    void countInversionsFull() {
        assertEquals(6, new CountInversions().count(new int[]{3, 2, 1, 0}));
    }

    @Test
    void countOneInversions() {
        assertEquals(1, new CountInversions().count(new int[]{0, 1, 2, 4, 3, 5}));
    }
}