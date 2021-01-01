package org.sedgewick.algorithms.part_two.week_four.question_three;

public class SuffixTree {
    private static final int R = 26; // english alphabet lower-case symbols
    private final String text;
    private Node root;

    public SuffixTree(String text) {
        this.root = new Node(null, -1);
        this.text = text;

        for (int i = 0; i < text.length(); i++)
            add(root, text.substring(i), i);
    }

    public int find(String s){
        return find(root.next[index(s.charAt(0))], s);
    }

    private int find(Node node, String s) {
        if (node == null) return -1;
        int i = countCommonSymbols(s, node.val);
        if (i == 0) return -1;
        if (i == s.length()) return node.index;

        String newS = s.substring(i);
        return find(node.next[index(newS.charAt(0))], newS);
    }

    private void add(Node root, String val, int index) {
        Node current = root.next[index(val.charAt(0))];
        if (current == null) {
            root.next[index(val.charAt(0))] = new Node(val, index);
            return;
        }

        Node prevCurrent = current;
        int i = countCommonSymbols(val, prevCurrent.val);
        if (i == val.length()){
            current = new Node(val, index);
        } else {
            current = new Node(val.substring(0, i), -1);
            String newVal = val.substring(i);
            add(current, newVal, index);
        }

        String newCurrentVal = prevCurrent.val.substring(i);
        prevCurrent.val = newCurrentVal;
        current.next[index(newCurrentVal.charAt(0))] = prevCurrent;
        root.next[index(val.charAt(0))] = current;
    }

    private int countCommonSymbols(String a, String b){
        int i;
        for (i = 0; i < Math.min(a.length(), b.length()); i++){
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
            this.next = new Node[R];
            this.index = index;
        }
    }
}
