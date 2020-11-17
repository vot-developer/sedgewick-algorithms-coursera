package org.sedgewick.algorithms.sort;

/**
 * 3 way quick sort.
 * time - (n * log n), worst - O (n*n), best - O(n)
 * space - O(1)
 * is stable = false
 */
public class QuickSort {

    public void sort(Comparable[] a) {
        if (a == null || a.length == 0)
            return;

        doSort(a, 0, a.length - 1);
    }

    private void doSort(Comparable[] a, int start, int end) {
        if (start >= end)
            return;

        Comparable pivot = a[start];
        int low = start;
        int high = end;
        int i = start;
        while (i <= high) {
            int compare = pivot.compareTo(a[i]);
            if (compare > 0) {
                swap(a, i++, low++);
            } else if (compare < 0) {
                swap(a, i, high--);
            } else {
                i++;
            }
        }

        doSort(a, start, low - 1);
        doSort(a, high + 1, end);
    }

    private void swap(Comparable[] array, int a, int b) {
        Comparable tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
