package org.sedgewick.algorithms.structures;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    Node root;

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value);

        int cmp = node.key.compareTo(key);
        if (cmp < 0)
            node.right = put(node.right, key, value);
        else if (cmp > 0)
            node.left = put(node.left, key, value);
        else
            node.val = value;

        return node;
    }

    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = node.key.compareTo(key);
            if (cmp < 0)
                node = node.right;
            else if (cmp > 0)
                node = node.left;
            else
                return node.val;
        }

        return null;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null)
            return null;

        int cmp = node.key.compareTo(key);

        if (cmp < 0)
            node.right = delete(node.right, key);
        else if (cmp > 0)
            node.left = delete(node.left, key);
        else {
            if (node.right == null)
                return node.left;

            if (node.left == null)
                return node.right;

            Node min = min(node.right);
            min.left = node.left;
            min.right = delete(node.right, min.key);
            return min;
        }

        return node;
    }

    public Value min() {
        if (root == null) return null;
        return min(root).val;
    }

    private Node min(Node node) {
        if (node.left != null)
            return min(node.left);

        return node;
    }

    public Value max() {
        if (root == null) return null;
        return max(root).val;
    }

    private Node max(Node node) {
        if (node.right != null)
            return max(node.right);

        return node;
    }

    public Iterable<Key> iterable() {
        return null;
    }

    class Node {
        Key key;
        Value val;
        Node left;
        Node right;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
}
