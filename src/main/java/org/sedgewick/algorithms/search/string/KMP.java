package org.sedgewick.algorithms.search.string;

public class KMP {
    private static final int R = 26;
    private final String pattern;
    private final int[][] states;

    public KMP(String pattern) {
        this.pattern = pattern;
        this.states = new int[R][pattern.length()]; //Do only for lowercase english alphabet letters

        states[index(pattern.charAt(0))][0] = 1;
        int x = 0;
        for (char i = 1; i < pattern.length(); i++) {
            for (int j = 0; j < R; j++)
                states[j][i] = states[j][x];
            states[index(pattern.charAt(i))][i] = i + 1;
            x = states[index(pattern.charAt(i))][x];
        }
    }

    public int search(String text){
        int j = 0;
        for (int i = 0; i < text.length(); i++){
            j = states[index(text.charAt(i))][j];
            if (j == pattern.length())
                return i - pattern.length() + 1;
        }
        return -1;
    }

    public int searchTandems(String text){
        int countOfTandem = 0;
        int j = 0;
        for (int i = 0; i < text.length(); i++){
            j = states[index(text.charAt(i))][j];
            if (j == pattern.length()) {
                countOfTandem++;
                j = 0;
            }
        }
        return countOfTandem;
    }

    private int index(char c) {
        if (c < 97 || c > 122) throw new IllegalArgumentException("support only lowercase english alphabet letters");
        return c - 97;
    }
}
