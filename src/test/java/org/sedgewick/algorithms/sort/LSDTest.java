package org.sedgewick.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LSDTest {

    @Test
    public void intSort(){
        int[] a = new int[]{101, 7, 12};
        LSD.sortByBite(a);
        assertArrayEquals(new int[] {7, 12, 101}, a);
    }

    @Test
    public void intSortBigValues(){
        int[] a = new int[]{2_123_335_234, 2_099_117_324, 2_000_999_994};
        LSD.sortByBite(a);
        assertArrayEquals(new int[] {2_000_999_994, 2_099_117_324, 2_123_335_234}, a);
    }

    @Test
    public void longSort(){
        long[] a = new long[]{101l, 7l, 12l};
        LSD.sortByByte(a);
        assertArrayEquals(new long[] {7l, 12l, 101l}, a);
    }

    @Test
    public void longSortBigValues(){
        long[] a = new long[]{2_123_335_234_199l, 2_099_117_324_321l, 2_999_999_994_999l};
        LSD.sortByByte(a);
        assertArrayEquals(new long[] {2_099_117_324_321l, 2_123_335_234_199l, 2_999_999_994_999l}, a);
    }
}