package org.sedgewick.algorithms.part_one.week_two.assigment_one;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    private class Node<Item> {
        Item value;
        Node next, prev;

        public Node(Item value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        validateIncomingItem(item);
        if (size == 0){
            head = new Node(item, tail, head);
            tail = head;
        } else {
            Node prevHead = head;
            head = new Node(item, tail, prevHead);
            prevHead.next = head;
            tail.prev = head;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        validateIncomingItem(item);
        if (size == 0){
            tail = new Node(item, tail, head);
            head = tail;
        } else {
            Node prevTail = tail;
            tail = new Node(item, prevTail, head);
            prevTail.prev = tail;
            head.next = tail;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        validateOutcomingItem();
        Item item = head.value;
        if (size() == 1) {
            head = null;
            tail = null;
        } else {
            head = head.prev;
            head.next = tail;
            tail.prev = head;
        }
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        validateOutcomingItem();
        Item item = tail.value;
        if (size() == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.next;
            tail.prev = head;
            head.next = tail;
        }
        size--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {

    }

    private void validateIncomingItem(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Argument can't be null");
    }

    private void validateOutcomingItem() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty");
    }

    private class DequeIterator implements Iterator<Item> {
        private Node<Item> current;
        private int step;

        public DequeIterator() {
            current = head;// iterator from tail to head. head not first step, first step will be head.next i.e. tail
            step = 0;
        }

        @Override
        public boolean hasNext() {
            return step != size;
        }

        @Override
        public Item next() {
            current = current.next;
            step++;
            return current.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();// by specification
        }

        @Override
        public void forEachRemaining(Consumer<? super Item> action) {
            throw new UnsupportedOperationException();
        }
    }
}
