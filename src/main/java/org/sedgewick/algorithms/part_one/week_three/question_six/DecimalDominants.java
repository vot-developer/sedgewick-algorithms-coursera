package org.sedgewick.algorithms.part_one.week_three.question_six;

public class DecimalDominants {

    public int findDecimal(int[] a) {
        int index;
        int end = a.length - 1;
        while (end >= 0){
            quickMaxSelect(a, 0, end);
            index = getInterval(a, end);

            if (end - index >= 9 || index == 0){
                return a[index];
            }
            end = index - 1;
        }

        return -1;
    }

    private void quickMaxSelect(int[] a, int start, int end) {
        if (start >= end)
            return;

        int pivot = a[start];
        int low = start;
        int high = end;
        int i = start;

        while (i <= high){
            if (a[i] < pivot){
                swap(a, i++, low++);
            } else if (a[i] > pivot){
                swap(a, i, high--);
            } else {
                i++;
            }
        }

        if (pivot == a[end]) {
            return;
        } else {
            quickMaxSelect(a, high + 1, end);
        }
    }

    private int getInterval(int[] a, int end) {
        int value = a[end];
        for (int i = end - 1; i >= 0; i--) {
            if (a[i] != value) return i + 1;
        }
        return 0;
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
