package org.sedgewick.algorithms.part_two.week_three.question_four;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void findTwoSum() {
        long[] a = new long[]{17l, 7l, 3l, 14l, 10l, 9l, 8l};
        List<Integer[]> result = new TwoSum().findTwoSum(a, 17l);
        assertEquals(3, result.size());
        assertArrayEquals(new Integer[]{2, 3}, result.get(0));
        assertArrayEquals(new Integer[]{1, 4}, result.get(1));
        assertArrayEquals(new Integer[]{6, 5}, result.get(2));
    }
}