package org.sedgewick.algorithms.part_one.week_two.question_five;

import java.util.Arrays;

public class Permutation {

    public boolean isPermutation(int[] a, int[] b) {
        if (a.length == 0 && b.length == 0)
            return true;

        if (a.length != b.length)
            return false;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}
