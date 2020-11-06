package org.sedgewick.algorithms.part_one.week_one.question_four;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumTest {

    @Test
    void findSolutions() {
        List<List<Integer>> result = new ThreeSum().findSolutions(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(2, result.size());
        assertArrayEquals(new int[]{-1, -1, 2}, result.get(0).stream().mapToInt(Integer::intValue).toArray());
        assertArrayEquals(new int[]{-1, 0, 1}, result.get(1).stream().mapToInt(Integer::intValue).toArray());
    }
}