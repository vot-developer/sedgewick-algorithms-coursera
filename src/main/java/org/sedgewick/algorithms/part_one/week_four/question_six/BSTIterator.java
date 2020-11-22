package org.sedgewick.algorithms.part_one.week_four.question_six;

public class BSTIterator {
    private TreeNode node;

    public BSTIterator(TreeNode root) {
        TreeNode aux;
        node = root;
        while (node != null) {
            if (node.left != null) {
                aux = node.left;
                while (aux.right != null && aux.right != node) aux = aux.right;
                if (aux.right == null) {
                    aux.right = node;
                    node = node.left;
                } else {
                    node = node.right;
                }
            } else {
                node = node.right;
            }
        }

        node = root;
        while (node != null && node.left != null) node = node.left;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        int result = node.val;

        TreeNode next = node.right;
        if (next == null) node = next;
        else if (next.left == null || next.left.val > node.val) {
            node = next;
            while (node.left != null) node = node.left;
        } else {
            node.right = null;
            node = next;
        }

        return result;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return node != null;
    }
}
