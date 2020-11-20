package org.sedgewick.algorithms.part_one.week_four.question_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DynamicMedianTest {

    @Test
    void test() {
        DynamicMedian dm = new DynamicMedian(10);
        dm.insert(1);
        dm.insert(2);
        dm.insert(3);
        assertEquals(2, dm.median());
    }

    @Test
    void cornerCase() {
        DynamicMedian dm = new DynamicMedian(10);
        dm.insert(1);
        assertEquals(1, dm.median());
    }

    @Test
    void testComplex() {
        DynamicMedian dm = new DynamicMedian(10);
        dm.insert(3);
        dm.insert(2);
        dm.insert(1);
        dm.insert(0);
        dm.insert(5);
        dm.insert(6);
        assertEquals(2, dm.median());
    }

    @Test
    void testRemove() {
        DynamicMedian dm = new DynamicMedian(10);
        dm.insert(3);
        dm.insert(2);
        dm.insert(1);
        dm.insert(0);
        dm.insert(5);
        dm.insert(6);
        dm.removeMedian();
        dm.removeMedian();
        dm.removeMedian();
        assertEquals(5, dm.median());
    }
}