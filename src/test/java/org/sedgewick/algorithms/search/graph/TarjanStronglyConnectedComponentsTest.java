package org.sedgewick.algorithms.search.graph;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TarjanStronglyConnectedComponentsTest {

    @Test
    void findSCC() {
        Map<Integer, Set<Integer>> digraph = new HashMap<>();
        digraph.put(0, new HashSet<>());
        digraph.put(1, new HashSet<>());
        digraph.put(2, new HashSet<>());
        digraph.put(3, new HashSet<>());
        digraph.put(4, new HashSet<>());
        digraph.put(5, new HashSet<>());

        digraph.get(0).add(1);
        digraph.get(0).add(2);

        //group 0 - 1 (0)
        digraph.get(1).add(0);

        //group - 2 - 3 - 4 (2)
        digraph.get(2).add(4);

        digraph.get(3).add(2);

        digraph.get(4).add(3);

        //group - 5 (5)
        digraph.get(5).add(4);

        assertArrayEquals(new int[]{0, 0, 2, 2, 2, 5}, TarjanStronglyConnectedComponents.findSCC(digraph));
    }
}