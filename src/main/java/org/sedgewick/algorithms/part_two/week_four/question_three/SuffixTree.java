package org.sedgewick.algorithms.part_two.week_four.question_three;

public class SuffixTree {
    private final org.sedgewick.algorithms.search.string.SuffixTree suffixTree;

    public SuffixTree(String text) {
        suffixTree = new org.sedgewick.algorithms.search.string.SuffixTree(text);
    }

    public int find(String s) {
        return suffixTree.find(s);
    }
}
