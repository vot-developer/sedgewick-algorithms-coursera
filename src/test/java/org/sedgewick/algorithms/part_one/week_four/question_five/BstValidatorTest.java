package org.sedgewick.algorithms.part_one.week_four.question_five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BstValidatorTest {
    @Test
    void test() {
        TreeNode tr3 = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4));
        TreeNode tr6 = new TreeNode(6);
        TreeNode root = new TreeNode(5, tr3, tr6);
        assertTrue(new BstValidator().isValidBST(root));
    }

    @Test
    void test2() {
        TreeNode tr3 = new TreeNode(3, new TreeNode(7, new TreeNode(1), null), new TreeNode(4));
        TreeNode tr6 = new TreeNode(6);
        TreeNode root = new TreeNode(5, tr3, tr6);
        assertFalse(new BstValidator().isValidBST(root));
    }
}