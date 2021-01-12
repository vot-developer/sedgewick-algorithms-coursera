package org.sedgewick.algorithms.part_two.week_five.question_six;

import java.util.ArrayList;
import java.util.List;

public class MoveToFrontCoding {
    private static final int R = 26;
    private static final int SHIFT = 97;
    private final List<Character> chars;

    public MoveToFrontCoding() {
        this.chars =  new ArrayList<>(R);
        for (char c = SHIFT; c < SHIFT + R; c++)
            chars.add(c - SHIFT, c);
    }

    public String encode(String s){
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++){
            int index = findAndReplaceToFront(s.charAt(i));
            sb.append(index);
        }
        return sb.toString();
    }

    /*
    time - O(n), need improve and use tree
     */
    private int findAndReplaceToFront(char c){
        int index = -1;
        for (int i = 0; i < chars.size(); i++)
            if (chars.get(i) == c)
                index = i;

        chars.remove(index);
        chars.add(0, c);
        return index;
    }
}
