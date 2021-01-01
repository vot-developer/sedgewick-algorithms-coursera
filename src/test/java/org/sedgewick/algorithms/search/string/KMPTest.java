package org.sedgewick.algorithms.search.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KMPTest {

    @Test
    void found(){
        KMP kmp = new KMP("ababac");
        assertEquals(6, kmp.search("aabacaababacaa"));
    }

    @Test
    void notFound(){
        KMP kmp = new KMP("ababac");
        assertEquals(-1, kmp.search("aabac"));
    }

    @Test
    void cornerCase(){
        KMP kmp = new KMP("ababac");
        assertEquals(0, kmp.search("ababac"));
    }
}