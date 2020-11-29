package org.sedgewick.algorithms.part_one.week_six.question_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FourSumTest {

    @Test
    void existSum() {
        assertTrue(new FourSum().existSum(new int[] {1, 2, 3, 4}));
    }

    @Test
    void notExistSum() {
        assertFalse(new FourSum().existSum(new int[] {1, 4, 6, 7}));
    }

    @Test
    void cornerCase() {
        assertFalse(new FourSum().existSum(new int[] {1, 4, 6}));
    }
}