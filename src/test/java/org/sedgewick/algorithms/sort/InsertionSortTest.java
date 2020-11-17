package org.sedgewick.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

class InsertionSortTest {

    @Test
    void sort() {
        int[] array = new int[]{8, 3, 0, 5, 6, 1, 9, 2, 7, 4};
        new InsertionSort().sort(array);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
    }

    @Test
    void sortWithDuplicates() {
        int[] array = new int[]{3, 3, 2, 3, 4, 3, 2, 1, 0, 5, 3, 3, 5, 3, 5, 3, 3, 2, 1, 3};
        new InsertionSort().sort(array);
        assertArrayEquals(new int[]{0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5, 5}, array);
    }
}