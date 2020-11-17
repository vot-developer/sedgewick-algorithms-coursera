package org.sedgewick.algorithms.sort;

/**
 * Shell Sort algorithm
 * <p>
 * time ~ O(n^3/2)
 * space - O(1)
 */
public class ShellSort {

    public void sort(int[] array) {
        //shell sort
        int h = 1;
        while (h < array.length / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            //insertion sort part
            for (int i = h; i < array.length; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (array[j - h] < array[j]) {
                        break; //another elements will be smaller as well
                    }
                    exchange(array, j, j - h);
                }
            }//end of insertion part
            h = h / 3;
        }
    }

    private void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
