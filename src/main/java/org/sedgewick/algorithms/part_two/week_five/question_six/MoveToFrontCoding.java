package org.sedgewick.algorithms.part_two.week_five.question_six;

import edu.princeton.cs.algs4.RedBlackBST;

public class MoveToFrontCoding {
    private static final int R = 26;
    private static final int SHIFT = 97;
    private final int[] charToId;
    private final RedBlackBST<Integer, Character> ids;
    private int startId;


    public MoveToFrontCoding() {
        this.charToId = new int[R];
        this.ids = new RedBlackBST<>();
        for (int i = 0; i < R; i++) {
            int id = i;
            charToId[i] = id;
            ids.put(id, (char) (i + SHIFT));
        }
        startId = 0;
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
    time - O(log n)
     */
    private int findAndReplaceToFront(char c){
        int id = charToId[c - SHIFT];
        int index = ids.rank(id);
        ids.delete(id);
        ids.put(--startId, c);
        charToId[c - SHIFT] = startId;
        return index;
    }
}
