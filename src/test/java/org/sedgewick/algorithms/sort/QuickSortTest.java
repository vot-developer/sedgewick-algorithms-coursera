package org.sedgewick.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

class QuickSortTest {

    @Test
    void sort() {
        Integer[] array = new Integer[]{8, 3, 0, 5, 6, 1, 9, 2, 7, 4};
        new QuickSort().sort(array);
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
    }

    @Test
    void sortWithDoubles() {
        Integer[] array = new Integer[]{8, 3, 0, 5, 3, 1, 6, 1, 9, 2, 1, 8, 7, 4, 1};
        new QuickSort().sort(array);
        assertArrayEquals(new Integer[]{0, 1, 1, 1, 1, 2, 3, 3, 4, 5, 6, 7, 8, 8, 9}, array);
    }

    @Test
    void cornerCase() {
        Integer[] array = new Integer[]{8, 3};
        new QuickSort().sort(array);
        assertArrayEquals(new Integer[]{3, 8}, array);
    }

    @Test
    void cornerCaseTwo() {
        Integer[] array = new Integer[]{1};
        new QuickSort().sort(array);
        assertArrayEquals(new Integer[]{1}, array);
    }
}