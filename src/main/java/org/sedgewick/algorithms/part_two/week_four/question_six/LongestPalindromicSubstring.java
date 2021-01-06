package org.sedgewick.algorithms.part_two.week_four.question_six;

import edu.princeton.cs.algs4.SuffixArray;

public class LongestPalindromicSubstring {
    private final String text;
    private final SuffixArray suffixArray;

    public LongestPalindromicSubstring(String text) {
        this.text = text;
        this.suffixArray = new SuffixArray(text);
    }

    //expected time - O(n * log(n))
    public String find() {
        StringBuilder sb = new StringBuilder(text);
        String reverse = sb.reverse().toString();
        String result = "";
        String match;
        for (int i = 0; i < reverse.length(); i++) { //time - O(n)
            String pattern = reverse.substring(i);
            match = foundCommonMatch(pattern); //expected time - O(log(n))
            if (match.length() == 0) continue;

            if (match.length() > result.length())
                result = match;
        }

        if (result.length() <= 2) return null;
        return result;
    }

    //expected time - O(log(n))
    private String foundCommonMatch(String pattern){
        int rank = suffixArray.rank(pattern); //time - O(log(n))
        int index1 = countCommonSymbols(rank, pattern);
        int index2 = 0; // two indexes because search don't find full match
        if (rank > 0)
            index2 = countCommonSymbols(rank - 1, pattern);
        return pattern.substring(0, Math.max(index1, index2));
    }

    private int countCommonSymbols(int rank, String pattern) {
        if (rank >= text.length()) return 0;
        int i;
        String s = text.substring(suffixArray.index(rank));
        for (i = 0; i < Math.min(s.length(), pattern.length()); i++) {
            if (s.charAt(i) != pattern.charAt(i)) break;
        }
        return i;
    }

    private String cutCommonString(String a, String b){
        int i;
        for (i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) != b.charAt(i)) break;
        }
        return a.substring(0, i);
    }
}
