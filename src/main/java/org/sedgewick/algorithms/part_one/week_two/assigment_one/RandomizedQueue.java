package org.sedgewick.algorithms.part_one.week_two.assigment_one;

import edu.princeton.cs.algs4.StdRandom;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int DEFAULT_SIZE = 2;
    private final Random random;
    private Item[] items;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        items = (Item[]) new Object[DEFAULT_SIZE];
        random = new Random();
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        validateIncomingItem(item);
        increaseSizeByNecessity();
        items[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        validateOutcomingItem();
        shrinkSizeByNecessity();

        int index = random.nextInt(size);
        Item item = items[index];
        items[index] = items[--size];
        items[size] = null;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        validateOutcomingItem();
        return items[random.nextInt(size)];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private void increaseSizeByNecessity() {
        if (size() == items.length) {
            Item[] newItems = (Item[]) new Object[2 * items.length];
            System.arraycopy(items, 0, newItems, 0, items.length);
            this.items = newItems;
        }
    }

    private void shrinkSizeByNecessity() {
        if (size() > 0 && size() < 0.25 * items.length) {
            Item[] newItems = (Item[]) new Object[items.length / 2];
            System.arraycopy(items, 0, newItems, 0, newItems.length);
            this.items = newItems;
        }
    }

    private void validateIncomingItem(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Argument can't be null");
    }

    private void validateOutcomingItem() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty");
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private final Item[] data;
        private int step;

        public RandomizedQueueIterator() {
            this.data = (Item[]) new Object[size];
            System.arraycopy(items, 0, this.data, 0, size);
            StdRandom.shuffle(data);
        }

        @Override
        public boolean hasNext() {
            return step != data.length;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();

            if (this.data.length != RandomizedQueue.this.size)
                throw new ConcurrentModificationException();

            return data[step++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
