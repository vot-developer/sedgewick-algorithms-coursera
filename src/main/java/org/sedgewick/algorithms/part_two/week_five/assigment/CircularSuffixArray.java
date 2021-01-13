package org.sedgewick.algorithms.part_two.week_five.assigment;

public class CircularSuffixArray {
    private static final int CUTOFF = 7;
    private final char[] chars;
    private final int size;
    private final int[] indices;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null)
            throw new IllegalArgumentException("constructor argument couldn't be null");
        this.chars = s.toCharArray();
        this.size = s.length();
        this.indices = new int[size];
        for (int i = 1; i < size; i++)
            indices[i] = i;

        sort(0, size - 1, 0);
    }

    private void sort(int start, int end, int d) {
        if (start >= end || d >= size)
            return;

        if (end - start < CUTOFF) {
            insertion(start, end, d);
            return;
        }

        char pivot = charAt(start, d);
        int lb = start, rb = end;
        int i = start + 1;

        while (i <= rb) {
            char c = charAt(i, d);
            if (c > pivot)
                swap(i, rb--);
            else if (c < pivot)
                swap(i++, lb++);
            else
                i++;
        }

        sort(start, lb - 1, d);
        sort(lb, rb, d + 1);
        sort(rb + 1, end, d);
    }

    private void insertion(int lower, int upper, int d) {
        for (int i = lower; i <= upper; i++)
            for (int j = i; j > lower && less(j, j - 1, d); j--)
                swap(j, j - 1);
    }

    private boolean less(int i, int j, int d) {
        for (int k = d; k < size; k++) {
            char a = charAt(i, k), b = charAt(j, k);
            if (a < b) return true;
            if (a > b) return false;
        }
        return false;
    }

    private void swap(int i, int j) {
        int temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;
    }

    private char charAt(int i, int d) {
        return chars[(d + indices[i]) % size];
    }

    // length of s
    public int length() {
        return size;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i >= size)
            throw new IllegalArgumentException("Invalid index value");
        return indices[i];
    }

    private class Arg {
        int start, end, d;

        public Arg(int start, int end, int d) {
            this.start = start;
            this.end = end;
            this.d = d;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
    }
}
