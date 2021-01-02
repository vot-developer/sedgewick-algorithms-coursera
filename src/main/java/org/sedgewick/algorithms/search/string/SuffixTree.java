package org.sedgewick.algorithms.search.string;

public class SuffixTree {
    private static final int R = 26; // english alphabet lower-case symbols
    private final String text;
    private Node root;

    public SuffixTree(String text) {
        this.root = new Node(null, -1);
        this.text = text;

        for (int i = 0; i < text.length(); i++)
            add(root, new Node(text.substring(i), i));
    }

    public int find(String s) {
        return find(root.next[index(s.charAt(0))], s);
    }

    public String findLongestSubstring(String text) {
        return findLongestSubstring(root.next[index(text.charAt(0))], text, new StringBuilder());
    }

    private int find(Node node, String s) {
        if (node == null) return -1;
        int i = countCommonSymbols(s, node.val);
        if (i == 0) return -1;
        if (i == s.length()) return node.index;

        String newS = s.substring(i);
        return find(node.next[index(newS.charAt(0))], newS);
    }

    private String findLongestSubstring(Node node, String text, StringBuilder found) {
        if (node == null) return found.toString();
        int i = countCommonSymbols(text, node.val);
        if (i == 0) return found.toString();
        if (i > 0) found.append(node.val, 0, i);
        if (i < node.val.length()) return found.toString();

        String newS = text.substring(i);
        if (newS.length() == 0) return found.toString();
        return findLongestSubstring(node.next[index(newS.charAt(0))], newS, found);
    }

    private void add(Node root, Node node) {
        Node current = root.next[index(node.val.charAt(0))];
        if (current == null) {
            root.next[index(node.val.charAt(0))] = node;
            return;
        }

        Node prevCurrent = new Node(current);
        int i = countCommonSymbols(node.val, prevCurrent.val);
        if (Math.min(prevCurrent.val.length(), node.val.length()) == i){
            if (prevCurrent.val.length() > node.val.length()) {
                extractOneExcess(root, prevCurrent, node, current, i);
            } else {
                extractOneExcess(root, node, prevCurrent, current, i);
            }
        } else {
            extractBothExcess(root, prevCurrent, node, current, i);
        }
    }

    private void extractOneExcess(Node root, Node excessNode, Node newNode, Node current, int i) {
        current = new Node(newNode);
        root.next[index(current.val.charAt(0))] = current;

        excessNode.val = excessNode.val.substring(i);
        add(current, excessNode);
    }

    private void extractBothExcess(Node root, Node excessNodeOne, Node excessNodeTwo, Node current, int i) {
        current = new Node(excessNodeOne.val.substring(0, i), -1);
        root.next[index(current.val.charAt(0))] = current;

        excessNodeOne.val = excessNodeOne.val.substring(i);
        add(current, excessNodeOne);

        excessNodeTwo.val = excessNodeTwo.val.substring(i);
        add(current, excessNodeTwo);
    }

    private int countCommonSymbols(String a, String b) {
        int i;
        for (i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) != b.charAt(i)) break;
        }
        return i;
    }

    private int index(char c) {
        if (c < 97 || c > 122) throw new IllegalArgumentException("support only lowercase english alphabet letters");
        return c - 97;
    }

    private class Node {
        private String val;
        private int index;
        private Node[] next;

        public Node(String val, int index) {
            this.val = val;
            this.index = index;
            this.next = new Node[R];
        }

        public Node(Node node){
            this.val = node.val;
            this.index = node.index;
            this.next = node.next;
        }
    }
}
