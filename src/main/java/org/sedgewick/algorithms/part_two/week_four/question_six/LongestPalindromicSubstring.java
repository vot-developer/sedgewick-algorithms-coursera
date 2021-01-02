package org.sedgewick.algorithms.part_two.week_four.question_six;

import org.sedgewick.algorithms.search.string.SuffixTree;

public class LongestPalindromicSubstring {
    private final String text;
    private final SuffixTree suffixTree;

    public LongestPalindromicSubstring(String text) {
        this.text = text;
        this.suffixTree = new SuffixTree(text);
    }

    public String find() {
        StringBuilder sb = new StringBuilder(text);
        String reverse = sb.reverse().toString();
        suffixTree.findLongestSubstring("repaperfdsaasd");
        String result = "";
        for (int i = 0; i < reverse.length(); i++) {
            String pattern = reverse.substring(i);
            String found = suffixTree.findLongestSubstring(pattern);
            if (found.length() > result.length())
                result = found;
        }

        if (result.length() <= 2) return null;
        return result;
    }
}
