package org.sedgewick.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

class HeapSortTest {

    @Test
    void sort() {
        Comparable[] array = new Comparable[]{8, 3, 0, 5, 6, 1, 9, 2, 7, 4};
        new HeapSort().sort(array);
        assertArrayEquals(new Comparable[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
    }

    @Test
    void sortWithDoubles() {
        Comparable[] array = new Comparable[]{8, 3, 0, 5, 3, 1, 6, 1, 9, 2, 1, 8, 7, 4, 1};
        new HeapSort().sort(array);
        assertArrayEquals(new Comparable[]{0, 1, 1, 1, 1, 2, 3, 3, 4, 5, 6, 7, 8, 8, 9}, array);
    }

    @Test
    void cornerCase() {
        Comparable[] array = new Comparable[]{8, 3};
        new HeapSort().sort(array);
        assertArrayEquals(new Comparable[]{3, 8}, array);
    }

    @Test
    void cornerCaseTwo() {
        Comparable[] array = new Comparable[]{1};
        new HeapSort().sort(array);
        assertArrayEquals(new Comparable[]{1}, array);
    }
}