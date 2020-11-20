package org.sedgewick.algorithms.part_one.week_one.question_three;

public class Successor {
    private final int[] max;

    public Successor(int size) {
        max = new int[size];
    }

    public void delete(int i) {
        if (i == max.length - 1) //couldn't delete last element
            return;

        if (max[i] != 0) //already deleted
            return;

        max[i] = findMax(i);
    }

    public int findSuccessor(int i) {
        if (max[i] == 0)//'i' didn't delete
            return i;

        return findMax(i);
    }

    private int findMax(int i) {
        int k = i + 1;
        while (max[k] != 0) {
            k = max[k];
        }
        max[i] = k; //optimization
        return k;
    }
}
