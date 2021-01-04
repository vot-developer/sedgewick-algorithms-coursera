package org.sedgewick.algorithms.part_two.week_four.question_three;

import org.sedgewick.algorithms.search.string.NaiveSuffixTree;

public class SuffixTree {
    private final NaiveSuffixTree naiveSuffixTree;

    public SuffixTree(String text) {
        naiveSuffixTree = new NaiveSuffixTree(text);
    }

    public int find(String s) {
        return naiveSuffixTree.find(s);
    }
}
