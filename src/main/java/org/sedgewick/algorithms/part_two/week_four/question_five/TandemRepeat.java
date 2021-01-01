package org.sedgewick.algorithms.part_two.week_four.question_five;

import org.sedgewick.algorithms.search.string.KMP;

public class TandemRepeat {
    private final String pattern;
    private final KMP kmp;

    public TandemRepeat(String pattern) {
        this.pattern = pattern;
        this.kmp = new KMP(pattern);
    }

    public int findRepeat(String s){
        return kmp.searchTandems(s);
    }
}
