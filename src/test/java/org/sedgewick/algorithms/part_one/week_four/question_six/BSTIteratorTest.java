package org.sedgewick.algorithms.part_one.week_four.question_six;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTIteratorTest {
    /*      5
          /   \
         3     6
        / \
       2  4
      /
     1
     */
    @Test
    void test() {
        TreeNode tr3 = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4));
        TreeNode tr6 = new TreeNode(6);
        TreeNode root = new TreeNode(5, tr3, tr6);
        BSTIterator iterator = new BSTIterator(root);
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(4, iterator.next());
        assertEquals(5, iterator.next());
        assertEquals(6, iterator.next());
        assertFalse(iterator.hasNext());
    }
}