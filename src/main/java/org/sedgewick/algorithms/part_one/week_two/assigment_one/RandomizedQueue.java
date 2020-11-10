package org.sedgewick.algorithms.part_one.week_two.assigment_one;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int DEFAULT_SIZE = 10;
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
        if (size == 0) {
            items[size++] = item;
        } else {
            int index = random.nextInt(size);
            Item savedItem = items[index];
            items[index] = item;
            items[size++] = savedItem;
        }
    }

    // remove and return a random item
    public Item dequeue() {
        validateOutcomingItem();
        shrinkSizeByNecessity();
        Item item = items[--size];
        items[size] = null;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        validateOutcomingItem();
        return items[random.nextInt(size)];
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.sample());
        System.out.println(queue.sample());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
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
        if (size() > 2 * DEFAULT_SIZE && size() < 0.25 * items.length) {
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
        private int step;

        @Override
        public boolean hasNext() {
            return step != size;
        }

        @Override
        public Item next() {
            return items[step++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
