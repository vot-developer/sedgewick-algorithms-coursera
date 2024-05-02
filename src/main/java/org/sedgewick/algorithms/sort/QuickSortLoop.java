package org.sedgewick.algorithms.sort;

/**
 * 3 way quick sort.
 * time - (n * log n), worst - O (n*n), best - O(n)
 * space - O(1)
 * is stable = false
 */
public class QuickSortLoop {

    public void sort(int[] arr) {
        quickSort(0, arr.length - 1, arr);
    }

    private void quickSort(int l, int r, int[] arr){
        if (l >= r)
            return;

        int pivot = arr[r];
        int i = l;
        for (int j = l; j < r; j++){
            if (arr[j] <= pivot){
                swap(i++, j, arr);
            }
        }
        swap(i, r, arr);

        //l <= x <= i : values <= pivot
        // i < x <= r : values > pivot

        quickSort(l, i - 1, arr);
        quickSort(i + 1, r, arr);
    }

    private void swap(int a, int b, int[] arr){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
