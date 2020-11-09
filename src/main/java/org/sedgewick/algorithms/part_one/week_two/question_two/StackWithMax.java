package org.sedgewick.algorithms.part_one.week_two.question_two;

public class StackWithMax {
    private Node top;
    private Node topMax;

    private class Node {
        private Node next;
        private Node prevMax;
        private Node nextMax;
        private int value;

        public Node(Node next, Node prevMax, Node nextMax, int value) {
            this.next = next;
            this.prevMax = prevMax;
            this.nextMax = nextMax;
            this.value = value;
        }
    }

    public void push(int value) {
        Node nextMax = topMax;
        Node prevMax = null;
        while (nextMax != null && nextMax.value >= value) {
            prevMax = nextMax;
            nextMax = nextMax.nextMax;
        }

        Node node;
        if (prevMax == null) {
            node = new Node(top, null, nextMax, value);
            top = node;
            topMax = node;
        } else {
            node = new Node(top, prevMax, nextMax, value);
            top = node;
            prevMax.next = node;
        }
    }

    public int pop() {
        if (top == null) {
            return Integer.MIN_VALUE;
        }

        Node prevTop = top;
        top = prevTop.next;

        Node prevMax = prevTop.prevMax;
        Node nextMax = prevTop.nextMax;
        if (prevMax == null){
            topMax = nextMax;
        } else {
            prevMax.nextMax = prevTop.nextMax;
            if (nextMax!= null){
                nextMax.prevMax = prevTop.prevMax;
            }
        }

        return prevTop.value;
    }

    public int top() {
        if (top == null) {
            return Integer.MIN_VALUE;
        } else {
            return top.value;
        }
    }

    public int getMax() {
        if (topMax == null) {
            return Integer.MIN_VALUE;
        } else {
            return topMax.value;
        }
    }
}
