package org.sedgewick.algorithms.part_one.week_two.assigment_one;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Deque<Item> implements Iterable<Item> {
    private final static int DEFAULT_SIZE = 10;
    private Item[] items;
    private int tail;
    private int head;
    private int size;

    // construct an empty deque
    public Deque() {
        this.items = (Item[]) new Object[DEFAULT_SIZE];
        this.size = 0;
        this.tail = 0;
        this.head = 0;
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
        increaseSizeByNecessity();

        if (head == items.length - 1) {
            items[head] = item;
            head = 0;
        } else {
            items[head++] = item;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        validateIncomingItem(item);
        increaseSizeByNecessity();

        if (tail == 0) {
            tail = items.length - 1;
            items[tail] = item;
        } else {
            items[--tail] = item;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        validateOutcomingItem();
        shrinkSizeByNecessity();

        size--;
        if (head == 0){
            head = items.length - 1;
            return items[head];
        } else {
            return items[--head];
        }
    }

    // remove and return the item from the back
    public Item removeLast() {
        validateOutcomingItem();
        shrinkSizeByNecessity();

        size--;
        if (tail == items.length - 1){
            Item temp = items[tail];
            tail = 0;
            return temp;
        } else {
            return items[tail++];
        }
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

    private void increaseSizeByNecessity() {
        if (size() == items.length) {
            Item[] newItems = (Item[]) new Object[2 * items.length];
            System.arraycopy(items, 0, newItems, 0, items.length);
            items = newItems;
        }
    }

    private void shrinkSizeByNecessity() {
        if (size() > 2 * DEFAULT_SIZE && size() < 0.25 * items.length) {
            Item[] newItems = (Item[]) new Object[items.length / 2];
            System.arraycopy(items, 0, newItems, 0, newItems.length);
            items = newItems;
        }
    }

    private class DequeIterator implements Iterator<Item>{
        private int index;

        public DequeIterator() {
            this.index = head;
        }

        @Override
        public boolean hasNext() {
            if (tail < head)
                return index - tail > 0;
            else
                return index - tail + items.length > 0;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();// by specification

            if (index == 0){
                index = items.length - 1;
                return items[0];
            } else {
                return items[index--];
            }
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
