package org.sedgewick.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

class HeapSortTest {

    @Test
    void sort() {
        int[] array = new int[]{8, 3, 0, 5, 6, 1, 9, 2, 7, 4};
        new HeapSort().sort(array);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
    }

    @Test
    void sortWithDoubles() {
        int[] array = new int[]{8, 3, 0, 5, 3, 1, 6, 1, 9, 2, 1, 8, 7, 4, 1};
        new HeapSort().sort(array);
        assertArrayEquals(new int[]{0, 1, 1, 1, 1, 2, 3, 3, 4, 5, 6, 7, 8, 8, 9}, array);
    }

    @Test
    void cornerCase() {
        int[] array = new int[]{8, 3};
        new HeapSort().sort(array);
        assertArrayEquals(new int[]{3, 8}, array);
    }

    @Test
    void cornerCaseTwo() {
        int[] array = new int[]{1};
        new HeapSort().sort(array);
        assertArrayEquals(new int[]{1}, array);
    }
}