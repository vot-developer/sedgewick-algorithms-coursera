package org.sedgewick.algorithms.part_one.week_three.question_five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectionInTwoSortedArraysTest {

    @Test
    void select() {
        int[] nums1 = new int[]{1, 2, 4, 5, 9};
        int[] nums2 = new int[]{0, 3, 6, 7, 8};
        int result = new SelectionInTwoSortedArrays().select(nums1, nums2, 4);
        assertEquals(3, result);
    }

    @Test
    void selectDiffSize() {
        int[] nums1 = new int[]{1, 2, 4, 5, 9, 10};
        int[] nums2 = new int[]{0, 3, 6, 7};
        int result = new SelectionInTwoSortedArrays().select(nums1, nums2, 9);
        assertEquals(9, result);
    }

    @Test
    void cornerCase() {
        int[] nums1 = new int[]{1, 2, 4, 5, 9, 10};
        int[] nums2 = new int[]{3};
        int result = new SelectionInTwoSortedArrays().select(nums1, nums2, 6);
        assertEquals(9, result);
    }
}