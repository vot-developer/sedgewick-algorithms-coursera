package org.sedgewick.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyIndexedCountingTest {

    @Test
    void sortEnglishLowLetters() {
        KeyIndexedCounting sort = new KeyIndexedCounting();
        assertEquals("aabbbcddefff", sort.sortEnglishLowLetters("dacffbdbfbea"));
    }
}