package org.sedgewick.algorithms.part_two.week_three.question_five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmericanFlagSortTest {

    @Test
    void sort() {
        int[] a = {231, 1, 140, 99, 1, 13};
        new AmericanFlagSort().sort(a, 256);
        assertArrayEquals(new int[]{1, 1, 13, 99, 140, 231}, a);
    }
}