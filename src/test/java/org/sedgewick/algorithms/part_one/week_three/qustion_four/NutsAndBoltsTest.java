package org.sedgewick.algorithms.part_one.week_three.qustion_four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NutsAndBoltsTest {

    @Test
    void sortOut() {
        int[] nuts = new int[]{3, 2, 1};
        int[] bolts = new int[]{2, 1, 3};
        new NutsAndBolts().sortOut(nuts, bolts);
        int[] expectedResult = new int[]{1, 2, 3};
        assertArrayEquals(expectedResult, nuts);
        assertArrayEquals(expectedResult, bolts);
    }

    @Test
    void cornerCase() {
        int[] nuts = new int[]{1};
        int[] bolts = new int[]{1};
        new NutsAndBolts().sortOut(nuts, bolts);
        int[] expectedResult = new int[]{1};
        assertArrayEquals(expectedResult, nuts);
        assertArrayEquals(expectedResult, bolts);
    }

    @Test
    void sortOutTen() {
        int[] nuts = new int[]{8, 3, 0, 5, 6, 1, 9, 2, 7, 4};
        int[] bolts = new int[]{2, 1, 3, 5, 9, 7, 8, 6, 4, 0};
        new NutsAndBolts().sortOut(nuts, bolts);
        int[] expectedResult = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expectedResult, nuts);
        assertArrayEquals(expectedResult, bolts);
    }
}