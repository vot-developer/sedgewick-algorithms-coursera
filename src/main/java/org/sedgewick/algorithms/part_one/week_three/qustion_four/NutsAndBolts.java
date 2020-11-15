package org.sedgewick.algorithms.part_one.week_three.qustion_four;

public class NutsAndBolts {

    public void sortOut(int [] nuts, int [] bolts){
        if (nuts == null || nuts.length == 0 || bolts == null || bolts.length == 0 || nuts.length != bolts.length)
            return;

        sort(bolts, nuts, 0, bolts.length - 1, 0);
    }

    private void sort(int[] bolts, int[] nuts, int start, int end, int pivotIndex){
        if (start >= end)
            return;

        int newPivotIndex = swapAroundPivot(bolts, start, end, nuts[pivotIndex]);
        if (newPivotIndex == -1)
            throw new IllegalArgumentException();

        swap(nuts, pivotIndex, newPivotIndex);
        swapAroundPivot(nuts, start, end, nuts[newPivotIndex]);

        sort(bolts, nuts, start, newPivotIndex - 1, start);
        sort(bolts, nuts, newPivotIndex + 1, end, newPivotIndex + 1);
    }

    private int swapAroundPivot(int[] a, int start, int end, int pivot){
        int i = start;
        int j = end;
        int newPivotIndex = -1;

        while(true){
            while (a[i] < pivot){
                if (i >= end || a[i] == pivot) break;
                i++;
            }

            while (a[j] > pivot){
                if (j <= start || a[j] == pivot) break;
                j--;
            }

            if (a[i] == pivot) newPivotIndex = i;
            if (a[j] == pivot) newPivotIndex = j;

            if (i >= j) break;
            swap(a, i, j);
        }

        return newPivotIndex;
    }

    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
