package org.sedgewick.algorithms.part_one.week_three.question_five;

import java.util.Arrays;

public class SelectionInTwoSortedArrays {

    /**
     * time - O(log k)
     * space - O(n)
     */
    public int select(int[] num1, int[] num2, int k) {
        return doSort(num1, num2, k - 1);
    }

    private int doSort(int[] num1, int[] num2, int k) {
        if (num1.length == 0)
            return num2[k];

        if (k == 0)
            return Math.min(num1[0], num2[0]);

        if (k == 1 && num1[0] != num2[0])
            return Math.max(num1[0], num2[0]);

        if (num1.length > num2.length)
            return doSort(num2, num1, k); // num1 - array with min size

        if (num1.length + num2.length <= k)
            throw new IllegalArgumentException();

        if (num1.length <= k)
            return num2[k - num1.length];

        int diff = k / 2;
        if (num1[diff] < num2[diff]) {
            num1 = Arrays.copyOfRange(num1, diff, num1.length);
            return doSort(num1, num2, k - diff);
        } else {
            num2 = Arrays.copyOfRange(num2, diff, num2.length);
            return doSort(num1, num2, k - diff);
        }
    }
}
