package org.sedgewick.algorithms.part_one.week_two.question_five;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static edu.princeton.cs.algs4.StdRandom.shuffle;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PermutationTest {

    @Test
    void isPermutation() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 12, 13, 14, 15};
        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        shuffle(b);

        assertTrue(new Permutation().isPermutation(a, b));
    }

    @Test
    void isNotPermutation() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 12, 13, 14, 15};
        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        b[0] = 0;
        shuffle(b);

        assertFalse(new Permutation().isPermutation(a, b));
    }
}