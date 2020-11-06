package org.sedgewick.algorithms.part_one.week_one.question_four;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> findSolutions(int[] nums) {
        Set<List<Integer>> solutions = new HashSet<>();
        Arrays.sort(nums);

        if (nums.length < 3)
            return new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    solutions.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                }
            }
        }

        return new ArrayList<>(solutions);
    }
}
