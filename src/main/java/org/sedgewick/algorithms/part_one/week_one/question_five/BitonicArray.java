package org.sedgewick.algorithms.part_one.week_one.question_five;

public class BitonicArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        int left = 0;
        int right = nums.length - 1;

        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[left] <= nums[mid]) {   //linear case - LEFT
                if (target < nums[mid] && target >= nums[left]) {   //target in left
                    right = mid - 1;
                } else {                    //target in right, NOT linear
                    left = mid + 1;
                }
            } else {                        //linear case - RIGHT
                if (target > nums[mid] && target <= nums[right]) { //target in right
                    left = mid + 1;
                } else {                    //target in left, NOT linear
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
