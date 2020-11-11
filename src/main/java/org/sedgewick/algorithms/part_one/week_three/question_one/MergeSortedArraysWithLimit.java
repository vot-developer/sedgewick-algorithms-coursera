package org.sedgewick.algorithms.part_one.week_three.question_one;

public class MergeSortedArraysWithLimit {

    public int[] merge(int[] nums1, int[] nums2, int n) {
        if (n == 0)
            return new int[]{};

        //regular merging
        int[] auxiliary = new int[n];
        int i = 0, j = 0;
        for (int k = 0; k < n; k++){
            if (j < n && (i == n || nums2[j] <= nums1[i])){
                auxiliary[k] = nums2[j++];
            } else {
                auxiliary[k] = nums1[i++];
            }
        }
        //move result from auxiliary array to unused (visited parts of source arrays)
        int freezeI = i;
        int freezeJ = j;
        for (int x = 0; x < freezeI; x++){
            nums1[x] = auxiliary[x];
        }
        for (int y = 0; y < freezeJ; y++){
            nums2[y] = auxiliary[freezeI + y];
        }
        //finish first part, using auxiliary again
        for (int k = 0; k < n; k++){
            if (j < n && (i == n || nums2[j] <= nums1[i])){
                auxiliary[k] = nums2[j++];
            } else {
                auxiliary[k] = nums1[i++];
            }
        }

        int [] result = new int[2*n];
        System.arraycopy(nums1, 0, result, 0, freezeI);
        System.arraycopy(nums2, 0, result, freezeI, freezeJ);
        System.arraycopy(auxiliary, 0, result, n, n);
        return result;
    }
}
