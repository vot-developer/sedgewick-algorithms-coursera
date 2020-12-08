package org.sedgewick.algorithms.part_two.week_one.assigment_one;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordNetTest {
    private static WordNet wordNet;

    @BeforeAll
    static void setUp(){
        wordNet = new WordNet("synsets.txt",
                "hypernyms.txt");
    }

    @Test
    void test(){
        assertEquals("person individual someone somebody mortal soul",
                wordNet.sap("Colin_luther_Powell", "Lee_Harvey_Oswald"));
        assertEquals(8,
                wordNet.distance("Colin_luther_Powell", "Lee_Harvey_Oswald"));
    }
}