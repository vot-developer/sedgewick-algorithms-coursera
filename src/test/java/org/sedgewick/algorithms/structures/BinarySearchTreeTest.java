package org.sedgewick.algorithms.structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    /*
                        8
                       /
                      3
                     / \
                    0   6
                       / \
                      4   7
                       \
                        5
     */
    @Test
    void put() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(8, "8");
        bst.put(3, "3");
        bst.put(0, "0");
        bst.put(6, "6");
        bst.put(7, "7");
        bst.put(4, "4");
        bst.put(5, "5");
        bst.delete(3);
        BinarySearchTree.Node root = bst.root;
        assertEquals(8, root.key);
        BinarySearchTree.Node newNode = root.left;
        assertEquals(4, newNode.key);
        assertEquals(0, newNode.left.key);
        assertEquals(6, newNode.right.key);
        assertEquals(5, newNode.right.left.key);
        assertEquals(7, newNode.right.right.key);
    }
}