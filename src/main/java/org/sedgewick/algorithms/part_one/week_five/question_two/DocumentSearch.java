package org.sedgewick.algorithms.part_one.week_five.question_two;

import edu.princeton.cs.algs4.BST;

import java.util.ArrayDeque;
import java.util.Deque;

public class DocumentSearch {

    public int search(String[] document, String[] indexes) {
        if (indexes.length < 2) return -1;

        BST<String, Deque<Integer>> bst = new BST<>();
        for (int i = 0; i < document.length; i++) {
            if (!bst.contains(document[i])) {
                Deque<Integer> queue = new ArrayDeque<>();
                queue.addLast(i);
                bst.put(document[i], queue);
            } else {
                bst.get(document[i]).addLast(i);
            }
        }

        Deque<Integer> queueMax = bst.get(indexes[0]);
        Deque<Integer> queueMin = bst.get(indexes[indexes.length - 1]);

        int finalStart = queueMax.getFirst(); //max interval
        int finalEnd = queueMin.getLast();
        if (!isInnerContains(indexes, bst, finalStart, finalEnd)) return -1;

        while (queueMax.size() > 0) {
            int start = queueMax.removeFirst();
            if (start > finalEnd) break;
            if (isInnerContains(indexes, bst, start, finalEnd)) {
                finalStart = start;
            } else {
                break;
            }
        }
        while (queueMin.size() > 0) {
            int end = queueMin.removeLast();
            if (end < finalStart) break;
            if (isInnerContains(indexes, bst, finalStart, end)) {
                finalEnd = end;
            } else {
                break;
            }
        }

        return finalEnd - finalStart + 1;
    }

    private boolean isInnerContains(String[] indexes, BST<String, Deque<Integer>> bst, int min, int max) {
        if (indexes.length == 2) return true;

        for (int i = 1; i < indexes.length - 1; i++) {
            if (!bst.contains(indexes[i])) return false;

            Deque<Integer> queue = bst.get(indexes[i]);
            for (Integer idx : queue) {
                if (idx < max && idx > min) return true;
            }
        }

        return false;
    }
}