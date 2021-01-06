package org.sedgewick.algorithms.part_two.week_four.assigment;

public class RTrieIterator {
    private RTrie.Node current;

    public RTrieIterator(RTrie.Node node) {
        this.current = node;
    }

    public RTrieIterator(RTrieIterator iterator) {
        this.current = iterator.current;
    }

    public void next(int index) {
        current = current.next(index);
    }

    public boolean hasNext(int index) {
        if (current == null) return false;
        return current.isNextExist(index);
    }

    public boolean isString() {
        if (current == null) return false;
        return current.isString();
    }
}
