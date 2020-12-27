package org.sedgewick.algorithms.part_two.week_four.question_one;

public class PrefixFreeCodes {

    public boolean isPrefixFree(String[] a){
        PrefixTrie trie = new PrefixTrie();
        boolean isFoundPrefix = false;
        for (String s : a)
            if (trie.put(s)) {
                isFoundPrefix = true;
                break;
            }

        return !isFoundPrefix;
    }
}
