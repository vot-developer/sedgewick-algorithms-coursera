package org.sedgewick.algorithms.part_one.week_five.question_three;

import edu.princeton.cs.algs4.RedBlackBST;

public class GeneralizedQueue<E> {
    private RedBlackBST<Integer, E> bst;
    private int index = 1;


    public GeneralizedQueue() {
        bst = new RedBlackBST<>();
    }

    public void push(E value) {
        bst.put(index++, value);
    }

    public E peek() {
        return bst.get(bst.min());
    }

    public E pop() {
        E result = bst.get(bst.min());
        bst.deleteMin();
        return result;
    }

    public boolean empty() {
        return bst.size() == 0;
    }

    public E get(int i) {
        return bst.get(bst.select(i - 1));
    }

    public void remove(int i) {
        bst.delete(bst.select(i - 1));
    }
}
