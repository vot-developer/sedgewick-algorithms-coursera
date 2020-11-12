package org.sedgewick.algorithms.part_one.week_three.question_one;

public class MergeSortedArraysWithLimit {

    public int[] merge(int[] a) {
        if (a.length == 0)
            return new int[]{};

        int mid = a.length / 2;
        int[] auxiliary = new int[mid];

        System.arraycopy(a, 0, auxiliary, 0, mid);

        int i = 0;
        int j = mid;
        for (int k = 0; k < a.length; k++){
            if (j == a.length || (i < mid && auxiliary[i] < a[j])){
                a[k] = auxiliary[i++];
            } else {
                a[k] = a[j++];
            }
        }
        return a;
    }
}
