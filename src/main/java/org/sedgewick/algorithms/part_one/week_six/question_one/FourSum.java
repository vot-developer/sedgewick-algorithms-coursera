package org.sedgewick.algorithms.part_one.week_six.question_one;

import java.util.HashSet;
import java.util.Set;

public class FourSum {

    public boolean existSum(int[] array) {
        if (array == null || array.length < 4) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++)
            for (int j = i + 1; j < array.length; j++) {
                int twoSum = array[i] + array[j];
                if (set.contains(twoSum)) return true;
                set.add(twoSum);
            }
        return false;
    }
}
