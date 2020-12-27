package org.sedgewick.algorithms.sort;

public class SuffixTrees {
    private final String[] radix;
    private Node root;

    public SuffixTrees(String[] radix) {
        this.radix = radix;
    }

    public void put(String key, Object val){
        root = put(root, key, val, 0);
    }

    public Object get(String key){
        return null;
    }

    private Node put(Node node, String key, Object val, int d){
        if (node == null) node = new Node();

        return node;
    }

    public static void main(String[] args){
        int c = '0';
        System.out.println(c);
        c = '1';
        System.out.println(c);
    }

    private class Node {
        Node[] next;
        Object val;
    }
}
