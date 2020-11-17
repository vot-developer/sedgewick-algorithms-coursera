package org.sedgewick.algorithms.sort;

/**
 * Insertion Sort algorithm
 * <p>
 * time - O(n*n) (O(n) - if a already sorted or partially sorted)
 * space - O(1)
 * is stable = true
 */
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
