package org.sedgewick.algorithms.part_two.week_five.assigment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularSuffixArrayTest {

    @Test
    void test(){
        CircularSuffixArray c = new CircularSuffixArray("ABRACADABRA!");
        assertEquals(11, c.index(0));
        assertEquals(10, c.index(1));
        assertEquals(7, c.index(2));
        assertEquals(0, c.index(3));
        assertEquals(3, c.index(4));
        assertEquals(5, c.index(5));
        assertEquals(8, c.index(6));
        assertEquals(1, c.index(7));
        assertEquals(4, c.index(8));
        assertEquals(6, c.index(9));
        assertEquals(9, c.index(10));
        assertEquals(2, c.index(11));
    }

    @Test
    void test2(){
        CircularSuffixArray c = new CircularSuffixArray("ABBBBBBBB");
        assertEquals(0, c.index(0));
        assertEquals(8, c.index(1));
        assertEquals(7, c.index(2));
        assertEquals(6, c.index(3));
        assertEquals(5, c.index(4));
        assertEquals(4, c.index(5));
        assertEquals(3, c.index(6));
        assertEquals(2, c.index(7));
        assertEquals(1, c.index(8));
    }

    @Test
    void test3(){
        CircularSuffixArray c = new CircularSuffixArray("BABABABABABABABABABA");
        assertEquals(1, c.index(0));
    }

    @Test
    void testLongString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++)
            sb.append("A");

        CircularSuffixArray c = new CircularSuffixArray(sb.toString());
        assertEquals(0, c.index(0));
        assertEquals(11, c.index(11));
    }
}