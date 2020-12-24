package org.sedgewick.algorithms.part_two.week_three.question_five;

public class AmericanFlagSort {

    /**
     * time - O(n)
     * space - O(R + n)
     */
    public void sort(int[] a, int R) {
        int n = a.length;
        int[] count = new int[R];

        for (int i = 0; i < n; i++)
            count[a[i]]++;

        for (int k = 0, r = 0; r < count.length; r++){
            if (count[r] == 0) continue;
            while(count[r]-- > 0)
                a[k++] = r;
        }
    }
}
