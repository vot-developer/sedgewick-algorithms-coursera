package org.sedgewick.algorithms.part_two.week_four.assigment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BoggleSolver {
    private final Set<String> dictionary;

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        this.dictionary = Arrays.stream(dictionary).collect(Collectors.toSet());
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        BoogleTree tree = new BoogleTree(board);
        Set<String> result = new HashSet<>();
        for (String s : dictionary) {
            if (s.length() < 3) continue;
            if (tree.find(s))
                result.add(s);
        }
        return result;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        if (!dictionary.contains(word))
            return 0;
        if (word.length() == 3 || word.length() == 4) return 1;
        if (word.length() == 5) return 2;
        if (word.length() == 6) return 3;
        if (word.length() == 7) return 5;
        if (word.length() > 7) return 11;
        return 0;
    }
}
