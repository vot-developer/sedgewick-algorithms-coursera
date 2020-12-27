package org.sedgewick.algorithms.part_two.week_four.question_one;

public class PrefixTrie {
    private Node root;
    private boolean isFoundPrefix;

    public PrefixTrie() {
    }

    private int index(char c) {
        return c - 48;
    }

    public boolean put(String key) {
        isFoundPrefix = false;
        root = put(key, 0, root);
        return isFoundPrefix;
    }

    private Node put(String key, int d, Node root) {
        if (root == null) root = new Node();
        if (root.value)
            isFoundPrefix = true;

        int i = index(key.charAt(d));

        if (d != key.length() - 1)
            root.next[i] = put(key, d + 1, root.next[i]);
        else {
            if (root.next[i] != null)
                isFoundPrefix = true;
            else
                root.next[i] = new Node();
            root.next[i].value = true;
        }
        return root;
    }

    private class Node {
        Node[] next = new Node[2];
        boolean value;
    }
}
