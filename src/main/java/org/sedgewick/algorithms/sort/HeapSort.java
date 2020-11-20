package org.sedgewick.algorithms.sort;

/**
 * time - (n * log n)
 * space - O(1)
 * is stable = false
 */
public class HeapSort {

    public void sort(int[] a) {
        int size = a.length;
        for (int k = size / 2; k > 0; k--) { // sort for max heap structure
            down(a, k, size);
        }
        while (size > 0) {
            swap(a, --size, 0); // simulation of remove max, actually just move it to end with shrink size
            down(a, 1, size);
        }
    }

    private void down(int[] a, int k, int size) {
        int j;
        while (2 * k <= size) {
            j = 2 * k;
            if (j < size && a[j - 1] < a[j])
                j++; // use j-1 instead of j for ref to array index, because we will broke math with 0th index
            if (a[k - 1] >= a[j - 1]) break;
            swap(a, k - 1, j - 1);
            k = j;
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
