package org.sedgewick.algorithms.part_two.week_five.question_four;

public class Node implements Comparable<Node> {
    char c;
    int freq;
    Node left;
    Node middle;
    Node right;

    public Node(char c, int freq, Node left, Node middle, Node right) {
        this.c = c;
        this.freq = freq;
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && middle == null && right == null;
    }

    @Override
    public int compareTo(Node n) {
        if (freq > n.freq) return 1;
        if (freq < n.freq) return -1;
        return 0;
    }
}
