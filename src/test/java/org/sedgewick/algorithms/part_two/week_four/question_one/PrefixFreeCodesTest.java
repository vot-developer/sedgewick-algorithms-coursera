package org.sedgewick.algorithms.part_two.week_four.question_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrefixFreeCodesTest {

    @Test
    void isPrefixFree() {
        assertTrue(new PrefixFreeCodes().isPrefixFree(new String[]{"01", "10", "0010", "1111"}));
    }

    @Test
    void isNotPrefixFree() {
        assertFalse(new PrefixFreeCodes().isPrefixFree(new String[]{"01","10","0010","10100"}));
    }
}