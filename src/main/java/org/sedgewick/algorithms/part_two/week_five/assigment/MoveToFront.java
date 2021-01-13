package org.sedgewick.algorithms.part_two.week_five.assigment;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {
    private static final int R = 256;

    public static void encode() {
        char[] charToId = new char[R];
        char[] idToChar = new char[R];
        for (char i = 0; i < R; i++) {
            charToId[i] = i;
            idToChar[i] = i;
        }

        while (!BinaryStdIn.isEmpty()) {
            char c = BinaryStdIn.readChar();
            char id = charToId[c];
            BinaryStdOut.write(id);
            for (char i = id; i > 0; i--) {
                idToChar[i] = idToChar[i - 1];
                charToId[idToChar[i]] = i;
            }
            idToChar[0] = c;
            charToId[c] = 0;
        }
        BinaryStdOut.close();
    }

    public static void decode() {
        char[] idToChar = new char[R];
        for (char i = 0; i < R; i++)
            idToChar[i] = i;

        while (!BinaryStdIn.isEmpty()) {
            char id = BinaryStdIn.readChar();
            char c = idToChar[id];
            BinaryStdOut.write(c);
            System.arraycopy(idToChar, 0, idToChar, 1, id);
            idToChar[0] = c;
        }
        BinaryStdOut.close();
    }

    public static void main(String[] args) {
        if (args[0].equals("+")) decode();
        else if (args[0].equals("-")) encode();
        else throw new IllegalArgumentException("Illegal argument: " + args[0]);
    }
}
