package org.sedgewick.algorithms.sort;

public class InsertionSort {

    public void sort(int[] a) {
        if (a == null || a.length <= 1)
            return;

        int j, tmp;
        for (int i = 1; i < a.length; i++) {
            j = i;
            while (j > 0 && a[j - 1] > a[j]) {
                tmp = a[j];
                a[j] = a[j - 1];
                a[--j] = tmp;
            }
        }
    }
}
