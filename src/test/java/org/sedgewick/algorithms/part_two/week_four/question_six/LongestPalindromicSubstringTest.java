package org.sedgewick.algorithms.part_two.week_four.question_six;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

    @Test
    void test(){
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring("dsaasdfrepaperaaac");
        assertEquals("repaper", lps.find());
    }

    @Test
    void notFound(){
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring("abcdefghijklmnopq");
        assertEquals(null, lps.find());
    }

    @Test
    void cornerCase(){
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring("abac");
        assertEquals("aba", lps.find());
    }
}