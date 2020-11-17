package org.sedgewick.algorithms.sort;

/**
 * Selection Sort algorithm
 * <p>
 * time - O(n*n)
 * space - O(1)
 */
public class SelectionSort {

    public void sort(int[] a) {
        int min, tmp;
        for (int i = 0; i < a.length; i++){
            min = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[j] < a[min]) min = j;
            }
            tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }
}
