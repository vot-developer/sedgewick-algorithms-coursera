package org.sedgewick.algorithms.structures;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

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
    private BinarySearchTree<Integer, String> bst;

    @Test
    void put() {
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

    @Test
    void iterateRecursively(){
        Iterator<Integer> it = bst.iterableRecursively().iterator();
        assertEquals(0, it.next());
        assertEquals(3, it.next());
        assertEquals(4, it.next());
        assertEquals(5, it.next());
        assertEquals(6, it.next());
        assertEquals(7, it.next());
        assertEquals(8, it.next());
    }

    @Test
    void iterate(){
        Iterator<Integer> it = bst.iterable().iterator();
        assertEquals(0, it.next());
        assertEquals(3, it.next());
        assertEquals(4, it.next());
        assertEquals(5, it.next());
        assertEquals(6, it.next());
        assertEquals(7, it.next());
        assertEquals(8, it.next());
    }

    @BeforeEach
    void setUp(){
        bst = new BinarySearchTree<>();
        bst.put(8, "8");
        bst.put(3, "3");
        bst.put(0, "0");
        bst.put(6, "6");
        bst.put(7, "7");
        bst.put(4, "4");
        bst.put(5, "5");
    }
}