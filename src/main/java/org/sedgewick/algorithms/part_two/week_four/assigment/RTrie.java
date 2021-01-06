package org.sedgewick.algorithms.part_two.week_four.assigment;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.TrieSET;

import java.util.Iterator;

public class RTrie implements Iterable<String> {
    private static final int R = 26;
    private static final int SHIFT = 65;
    private Node root;

    public RTrie() {
    }

    public RTrie(String[] strings) {
        for (String s : strings)
            if (s.length() > 2)
                add(s);
    }

    public Node getRoot() {
        return root;
    }

    public boolean contains(String key) {
        Node x = this.get(root, key, 0);
        if (x == null)
            return false;
        return x.isString;
    }

    private Node get(Node x, String key, int d) {
        if (x == null)
            return null;
        else if (d == key.length())
            return x;
        else {
            char c = key.charAt(d);
            return get(x.next[c - SHIFT], key, d + 1);
        }
    }

    public void add(String key) {
        root = add(root, key, 0);
    }

    private Node add(Node node, String key, int d) {
        if (node == null)
            node = new Node();

        if (d == key.length())
            node.isString = true;
        else {
            char c = key.charAt(d);
            node.next[c - SHIFT] = add(node.next[c - SHIFT], key, d + 1);
        }

        return node;
    }

    public Iterator<String> iterator() {
        return this.keysWithPrefix("").iterator();
    }

    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> results = new Queue<>();
        Node x = this.get(this.root, prefix, 0);
        collect(x, new StringBuilder(prefix), results);
        return results;
    }

    private void collect(Node x, StringBuilder prefix, Queue<String> results) {
        if (x != null) {
            if (x.isString) {
                results.enqueue(prefix.toString());
            }

            for(char c = SHIFT; c < SHIFT + R; ++c) {
                prefix.append(c);
                collect(x.next[c - SHIFT], prefix, results);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }

    static class Node {
        private Node[] next;
        private boolean isString;

        private Node() {
            this.next = new Node[R];
        }

        public Node next(int i) {
            return next[i - SHIFT];
        }

        public boolean isNextExist(int i) {
            return next[i - SHIFT] != null;
        }

        public boolean isString() {
            return isString;
        }
    }
}
