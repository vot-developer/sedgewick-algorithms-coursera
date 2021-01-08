package org.sedgewick.algorithms.part_two.week_five.question_three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NFATest {
    @Test
    public void testPlus(){
        NFA nfa = new NFA("ab+");
        assertTrue(nfa.recognizes("ab"));
        assertTrue(nfa.recognizes("abb"));
        assertFalse(nfa.recognizes("a"));
    }

    @Test
    public void testMultiwayOr(){
        NFA nfa = new NFA("(a|b|c|d)b+");
        assertTrue(nfa.recognizes("cb"));
        assertTrue(nfa.recognizes("cbb"));
        assertFalse(nfa.recognizes("c"));
    }
}