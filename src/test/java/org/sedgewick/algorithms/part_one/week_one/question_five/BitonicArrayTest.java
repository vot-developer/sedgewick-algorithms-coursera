package org.sedgewick.algorithms.part_one.week_one.question_five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitonicArrayTest {

    @Test
    void search() {
        int result = new BitonicArray().search(new int[] {4,5,6,7,0,1,2}, 0);
        assertEquals(4, result);
    }

    @Test
    void searchNotExistElement() {
        int result = new BitonicArray().search(new int[] {4,5,6,7,0,1,2}, 3);
        assertEquals(-1, result);
    }
}