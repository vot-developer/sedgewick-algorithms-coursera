package org.sedgewick.algorithms.part_one.week_two.question_two;

public class StackWithMax {
    private Node top;

    private class Node {
        private Node next;
        private int value;
        private int max;

        public Node(Node next, int value, int max) {
            this.next = next;
            this.value = value;
            this.max = max;
        }
    }

    public void push(int value) {
        if (top == null){
            top = new Node(null, value, value);
        } else {
            Node prevTop = top;
            top = new Node(prevTop, value, Math.max(prevTop.max, value));
        }
    }

    public int pop() {
        if (top == null) {
            return 0;
        }

        Node prevTop = top;
        top = prevTop.next;
        return prevTop.value;
    }

    public int top() {
        if (top == null) {
            return 0;
        } else {
            return top.value;
        }
    }

    public int getMax() {
        if (top == null) {
            return 0;
        } else {
            return top.max;
        }
    }
}
