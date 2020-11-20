package org.sedgewick.algorithms.part_one.week_three.question_five;

public class SelectionInTwoSortedArraysWithDuplicates {

    /**
     * O(log(n1+n2))
     * worst case ~ O(n) with duplicates only
     */
    public int select(int[] num1, int[] num2, int k) {
        if (k <= 0 || num1 == null || num2 == null || num1.length + num2.length == 0)
            throw new IllegalArgumentException();

        if (k == 1)
            return Math.min(num1[0], num2[0]);

        if (k == 2 && num1[0] != num2[0])
            return Math.max(num1[0], num2[0]);

        int value = Math.min(num1[0], num2[0]);
        int position = 1;
        int leftNums1 = 0, leftNums2 = 0;
        int result1;
        int result2;
        do {
            position++;
            value = Math.max(value + 1, Math.max(num1[leftNums1], num1[leftNums2]));

            result1 = findIndex(num1, value, leftNums1);
            if (result1 > 0) leftNums1 = result1;

            result2 = findIndex(num2, value, leftNums2);
            if (result2 > 0) leftNums2 = result2;

            if (result1 < 0 && result2 < 0)
                position--;
        } while (position < k);

        return value;
    }

    private int findIndex(int a[], int value, int start) {
        return findIndex(a, value, start, a.length - 1);
    }

    private int findIndex(int a[], int value, int start, int end) {
        if (start > end)
            return -1;

        if (start == end && a[start] != value)
            return -1;

        int mid = start + (end - start) / 2;
        if (a[mid] < value) {
            return findIndex(a, value, mid + 1, end);
        } else if (a[mid] > value) {
            return findIndex(a, value, start, mid - 1);
        } else {
            return mid;
        }
    }
}
