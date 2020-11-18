package org.sedgewick.algorithms.part_one.week_four.question_three;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaxicabNumbersTest {

    @Test
    void test() {
        List<List<Integer>> result = new TaxicabNumbers().find(13);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(1, 12, 9, 10), result.get(0));
    }

    @Test
    void test2() {
        List<List<Integer>> result = new TaxicabNumbers().find(17);
        assertEquals(2, result.size());
        assertEquals(Arrays.asList(2, 16, 9, 15), result.get(0));
    }
}