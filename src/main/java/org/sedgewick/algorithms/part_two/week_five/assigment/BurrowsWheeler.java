package org.sedgewick.algorithms.part_two.week_five.assigment;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {
    private static final int R = 256;

    public static void transform() {
        String s = BinaryStdIn.readString();
        CircularSuffixArray array = new CircularSuffixArray(s);
        int first = -1, n = array.length();
        char[] last = new char[n];

        for (int i = 0; i < n; i++) {
            int index = array.index(i);
            if (index == 0) first = i;
            last[i] = s.charAt(index == 0 ? n - 1 : index - 1);
        }

        BinaryStdOut.write(first);
        for (char c : last) BinaryStdOut.write(c);
        BinaryStdOut.close();
    }

    public static void inverseTransform() {
        int row = BinaryStdIn.readInt();
        String last = BinaryStdIn.readString();
        int n = last.length();
        int[] count = new int[R + 1];
        int[] next = new int[n];

        for (int i = 0; i < n; i++) count[last.charAt(i) + 1]++;
        for (int i = 0; i < R; i++) count[i + 1] += count[i];
        for (int i = 0; i < n; i++) next[count[last.charAt(i)]++] = i;

        for (int i = next[row], j = 0; j < n; i = next[i], j++)
            BinaryStdOut.write(last.charAt(i));
        BinaryStdOut.close();
    }

    public static void main(String[] args) {
        if      (args[0].equals("+")) inverseTransform();
        else if (args[0].equals("-")) transform();
        else throw new IllegalArgumentException("Illegal argument: " + args[0]);
    }
}
