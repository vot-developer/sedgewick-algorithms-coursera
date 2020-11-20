package org.sedgewick.algorithms.part_one.week_three.question_two;

public class CountInversions {

    public int count(int a[]) {
        if (a.length < 2)
            return 0;

        return doCount(a, 0, a.length - 1);
    }

    private int doCount(int a[], int start, int end) {
        int count = 0;

        if (start >= end)
            return count;

        int mid = start + (end - start) / 2;
        count += doCount(a, start, mid);
        count += doCount(a, mid + 1, end);
        if (a[mid] <= a[mid + 1])
            return count;

        int[] sort = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        for (int k = 0; k < sort.length; k++) {
            if (i == mid + 1) {
                sort[k] = a[j++];
                continue;
            }
            if (j == end + 1) {
                sort[k] = a[i++];
                continue;
            }
            if (a[i] < a[j]) {
                sort[k] = a[i++];
            } else {
                sort[k] = a[j++];
                count += mid + 1 - i;
            }
        }

        System.arraycopy(sort, 0, a, start, sort.length);
        return count;
    }
}
