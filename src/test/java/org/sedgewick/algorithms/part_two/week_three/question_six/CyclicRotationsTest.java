package org.sedgewick.algorithms.part_two.week_three.question_six;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CyclicRotationsTest {

    @Test
    void find() {
        String[] a = new String[]{
                "algorithms", "polynomial", "sortsuffix", "boyermoore",
                "structures", "minimumcut", "suffixsort", "stackstack",
                "binaryheap", "digraphdfs", "stringsort", "digraphbfs"};
        List<List<String>> result = new CyclicRotations().find(a);
        assertEquals(1, result.size());
        assertArrayEquals(new String[]{"sortsuffix", "suffixsort"}, result.get(0).toArray());
    }

    @Test
    void cornerCase() {
        String[] a = new String[]{
                "aa", "ab", "ac", "ba",
                "aa", "ac", "bc", "ca"};
        List<List<String>> result = new CyclicRotations().find(a);
        assertEquals(3, result.size());
        assertArrayEquals(new String[]{"aa", "aa"}, result.get(0).toArray());
        assertArrayEquals(new String[]{"ab", "ba"}, result.get(1).toArray());
        assertArrayEquals(new String[]{"ac", "ac", "ca"}, result.get(2).toArray());
    }
}