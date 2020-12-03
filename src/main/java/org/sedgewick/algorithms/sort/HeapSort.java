package org.sedgewick.algorithms.sort;

/**
 * time - (n * log n)
 * space - O(1)
 * is stable = false
 */
public class HeapSort {

    //do math with indexes > 0 (from 1, because 2 = 1 * 2 and 2!= 0 * 2), but array ref with -1 adjustment
    public void sort(Comparable[] a) {
        int size = a.length;
        for (int k = size / 2; k > 0; k--){
            down(a, k, size);
        }

        while (size > 0){
            swap(a, 1, size--);
            down(a, 1, size);
        }
    }

    private void down(Comparable[] a, int k, int size) {
        int j;
        while (2 * k <= size) {
            j = 2 * k;
            if (j + 1 < size && less(j, j + 1, a))
                j++;

            if (less(j, k, a))
                break;

            swap(a, j, k);
            k = j;
        }
    }

    private void swap(Comparable[] a, int i, int j) {
        i--; j--; //-1 adjustment
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int i, int j, Comparable[] a) {
        i--; j--; //-1 adjustment
        return a[i].compareTo(a[j]) < 0;
    }
}
