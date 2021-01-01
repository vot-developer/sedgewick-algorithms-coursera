package org.sedgewick.algorithms.part_two.week_four.question_four;

import org.sedgewick.algorithms.search.string.KMP;

public class CyclicRotation {

    public boolean isCyclicRotation(String s, String t){
        if (s.length() != t.length()) return false;
        if (s.length() == 0) return true;
        if (s.equals(t)) return true;

        KMP kmp = new KMP(s);
        return kmp.search(t + t) >= 0;
    }
}
