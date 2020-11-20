package org.sedgewick.algorithms.part_one.week_three.question_six;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecimalDominantsTest {

    @Test
    void findDecimal() {
        int result = new DecimalDominants().findDecimal(new int[]{3, 3, 2, 3, 4, 3, 2, 1, 0, 5, 3, 3, 5, 3, 5, 3, 3, 2, 1, 3});
        assertEquals(3, result);
    }
}