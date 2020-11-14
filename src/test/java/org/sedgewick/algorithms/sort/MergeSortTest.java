package org.sedgewick.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

class MergeSortTest {

    @Test
    void sort() {
        Integer[] array = new Integer[]{8, 3, 0, 5, 6, 1, 9, 2, 7, 4};
        new MergeSort().sort(array);
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
    }

    @Test
    void cornerCase() {
        Integer[] array = new Integer[]{1};
        new MergeSort().sort(array);
        assertArrayEquals(new Integer[]{1}, array);
    }

    @Test
    void cornerCaseTwo() {
        Integer[] array = new Integer[]{3, 1};
        new MergeSort().sort(array);
        assertArrayEquals(new Integer[]{1, 3}, array);
    }
}