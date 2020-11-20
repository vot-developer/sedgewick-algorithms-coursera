package org.sedgewick.algorithms.part_one.week_three.question_five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectionInTwoSortedArraysWithDuplicatesTest {

    @Test
    void select() {
        int[] nums1 = new int[]{1, 1, 2, 3, 3};
        int[] nums2 = new int[]{0, 2, 2, 3, 4};
        int result = new SelectionInTwoSortedArraysWithDuplicates().select(nums1, nums2, 4);
        assertEquals(3, result);
    }

    @Test
    void selectTwo() {
        int[] nums1 = new int[]{5, 5, 7, 7, 9};
        int[] nums2 = new int[]{9, 11, 11, 11, 11, 11};
        int result = new SelectionInTwoSortedArraysWithDuplicates().select(nums1, nums2, 4);
        assertEquals(11, result);
    }
}