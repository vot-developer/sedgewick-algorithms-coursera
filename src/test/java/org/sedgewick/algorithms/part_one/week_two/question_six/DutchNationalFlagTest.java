package org.sedgewick.algorithms.part_one.week_two.question_six;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

class DutchNationalFlagTest {

    @Test
    void sortColors() {
        int[] array = new int[]{2, 0, 2, 2, 1, 1, 1, 0};
        new DutchNationalFlag().sortColors(array);
        assertArrayEquals(new int[]{0, 0, 1, 1, 1, 2, 2, 2}, array);
    }

    @Test
    void sortColorsShort() {
        int[] array = new int[]{2, 0, 1};
        new DutchNationalFlag().sortColors(array);
        assertArrayEquals(new int[]{0, 1, 2}, array);
    }
}