package org.sedgewick.algorithms.part_two.week_four.question_three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuffixTreeTest {

    @Test
    void findFirst(){
        SuffixTree suffixTree = new SuffixTree("banana");
        assertEquals(0, suffixTree.find("banana"));
    }

    @Test
    void findSecond(){
        SuffixTree suffixTree = new SuffixTree("banana");
        assertEquals(1, suffixTree.find("anana"));
    }

    @Test
    void findLast(){
        SuffixTree suffixTree = new SuffixTree("banana");
        assertEquals(5, suffixTree.find("a"));
    }

    @Test
    void cornerCase(){
        SuffixTree suffixTree = new SuffixTree("a");
        assertEquals(0, suffixTree.find("a"));
    }
}