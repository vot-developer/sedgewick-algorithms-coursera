package org.sedgewick.algorithms.part_two.week_one.assigment_one;

import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutcastTest {
    private static Outcast outcast;

    @BeforeAll
    static void setUp(){
        outcast = new Outcast(new WordNet("synsets.txt",
                "hypernyms.txt"));
    }

    @Test
    void outcast() {
        In in = new In("outcast5.txt");
        String[] nouns = in.readAllStrings();
        assertEquals("table", outcast.outcast(nouns));
    }

    @Test
    void outcast2() {
        In in = new In("outcast7.txt");
        String[] nouns = in.readAllStrings();
        assertEquals("India", outcast.outcast(nouns));
    }
}