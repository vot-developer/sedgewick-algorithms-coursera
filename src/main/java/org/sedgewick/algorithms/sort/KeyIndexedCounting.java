package org.sedgewick.algorithms.sort;

public class KeyIndexedCounting {
    public String sortEnglishLowLetters(String s){
        int[] count = new int[27]; // 26 alphabet symbols + 1

        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 97 + 1]++; // 97 - unicode symbol of 'a' - start of low alphabet symbols

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        char[] aux = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
            aux[count[s.charAt(i) - 97]++] = s.charAt(i);

        return new String(aux);
    }
}
