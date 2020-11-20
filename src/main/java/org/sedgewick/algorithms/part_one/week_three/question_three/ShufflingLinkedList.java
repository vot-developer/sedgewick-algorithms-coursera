package org.sedgewick.algorithms.part_one.week_three.question_three;

import java.util.Random;

public class ShufflingLinkedList {
    private final Random random = new Random();
    private Node head;
    private int size;

    public void add(int value) {
        size++;
        if (head == null) {
            head = new Node(value, null);
        } else {
            head = new Node(value, head);
        }
    }

    public void print() {
        Node node = head.next;
        System.out.print(head.value);
        while (node != null) {
            System.out.print(" -> ");
            System.out.print(node.value);
            node = node.next;
        }
        System.out.println();
    }

    public void shuffle() {
        doShuffle(head, size);
    }

    private void doShuffle(Node startNode, int size) {
        if (size <= 1)
            return;

        int k = 0;
        int mid = size / 2;
        Node midNode = startNode;
        while (k < mid) {
            midNode = midNode.next;
            k++;
        }
        doShuffle(startNode, mid);
        doShuffle(midNode, size - mid);

        merge(startNode, midNode, mid, size - mid);
    }

    private void merge(Node first, Node second, int firstSize, int secondSize) {
        int i = 0, j = 0;
        while (i < firstSize && j < secondSize) {
            if (i == firstSize) {
                swapByChance(first, second);
                j++;
                second = second.next;
                continue;
            } else if (j == secondSize) {
                swapByChance(first, second);
                i++;
                first = first.next;
                continue;
            } else {
                swapByChance(first, second);
                i++;
                j++;
                first = first.next;
                second = second.next;
            }
        }
    }

    private void swapByChance(Node a, Node b) {
        if (random.nextInt(2) > 0)
            return;

        int tmp = a.value;
        a.value = b.value;
        b.value = tmp;
    }

    private class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
