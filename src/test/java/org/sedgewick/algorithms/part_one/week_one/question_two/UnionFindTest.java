package org.sedgewick.algorithms.part_one.week_one.question_two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnionFindTest {

    @Test
    void test() {
        UnionFind uf = new UnionFind(10);
        uf.union(1, 2);
        uf.union(6, 9);
        uf.union(2, 6);
        assertEquals(9, uf.find(1));
    }
}