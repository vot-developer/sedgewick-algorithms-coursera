package org.sedgewick.algorithms.part_one.week_three.question_one;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

class MergeSortedArraysWithLimitTest {

    @Test
    void merge() {
        int[] result = new MergeSortedArraysWithLimit().merge(new int[]{1, 3, 5, 7, 9, 0, 2, 4, 6, 8});
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, result);
    }

    @Test
    void mergeTinyArrays() {
        int[] result = new MergeSortedArraysWithLimit().merge(new int[]{1, 0});
        assertArrayEquals(new int[]{0, 1}, result);
    }
}