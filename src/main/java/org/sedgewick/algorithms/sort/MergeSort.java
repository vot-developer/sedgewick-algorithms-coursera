package org.sedgewick.algorithms.sort;

public class MergeSort {

    public void sort(Comparable[] array) {
        Comparable[] auxiliary = new Comparable[array.length];
        System.arraycopy(array, 0, auxiliary, 0, array.length);

        sort(array, auxiliary, 0, array.length - 1);
    }

    private void sort(Comparable[] array, Comparable[] auxiliary, int start, int end) {
        if (start >= end)
            return;

        int mid = start + (end - start) / 2;

        sort(array, auxiliary, start, mid);
        sort(array, auxiliary, mid + 1, end);
        mergeSortedArrays(auxiliary, array, start, mid, end); //optimization - cut down one copy by switch arrays
    }

    private void mergeSortedArrays(Comparable[] array, Comparable[] auxiliary, int start, int mid, int end) {
        if (mid + 1 <= end && !isLess(array[mid + 1], array[mid])) //already sorted
            return;

        int length = end - start + 1;
        // using insertion sort on small arrays
        if (length < 7) {
            insertionSort(array, auxiliary, start, mid, end, length);
        }

        System.arraycopy(array, start, auxiliary, start, length);
        int i = start;
        int j = mid + 1;
        for (int k = 0; k < length; k++) {
            if ((j > end) || (i <= mid) && isLess(array[i], array[j])) {
                auxiliary[k] = array[i++];
            } else {
                auxiliary[k] = array[j++];
            }
        }
    }

    private void insertionSort(Comparable[] array, Comparable[] auxiliary, int start, int mid, int end, int length) {
        for (int i = start; i <= end; i++)
            for (int j = i; j > start && isLess(array[j], array[j - 1]); j--)
                swap(array, j, j - 1);
        System.arraycopy(array, start, auxiliary, start, length);
    }

    private boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private void swap(Comparable[] array, int a, int b) {
        Comparable tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
