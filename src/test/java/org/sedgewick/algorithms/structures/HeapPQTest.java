package org.sedgewick.algorithms.structures;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

class HeapPQTest {

    @Test
    void sort() {
        HeapPQ pq = new HeapPQ(new Comparable[]{8, 3, 0, 5, 6, 1, 9, 2, 7, 4});
        Comparable[] array = pq.sort();
        assertArrayEquals(new Comparable[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
    }

    @Test
    void sortWithDoubles() {
        HeapPQ pq = new HeapPQ(new Comparable[]{8, 3, 0, 5, 3, 1, 6, 1, 9, 2, 1, 8, 7, 4, 1});
        Comparable[] array = pq.sort();
        assertArrayEquals(new Comparable[]{0, 1, 1, 1, 1, 2, 3, 3, 4, 5, 6, 7, 8, 8, 9}, array);
    }

    @Test
    void cornerCase() {
        HeapPQ pq = new HeapPQ(new Comparable[]{8, 3});
        Comparable[] array = pq.sort();
        assertArrayEquals(new Comparable[]{3, 8}, array);
    }

    @Test
    void cornerCaseTwo() {
        HeapPQ pq = new HeapPQ(new Comparable[]{1});
        Comparable[] array = pq.sort();
        assertArrayEquals(new Comparable[]{1}, array);
    }
}