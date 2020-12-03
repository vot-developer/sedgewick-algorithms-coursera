package org.sedgewick.algorithms.structures;

public class HeapPQ {
    private Comparable[] values;
    private int size = 0;

    public HeapPQ(int size) {
        this.values = new Comparable[size + 1];
    }

    public HeapPQ(Comparable[] array) {
        this.values = new Comparable[array.length + 1];
        for (Comparable value : array)
            insert(value);
    }

    public void insert(Comparable value) {
        values[++size] = value;
        swim(size);
    }

    public Comparable delMax() {
        Comparable result = values[1];
        swap(1, size);
        values[size--] = null;
        sink(1);
        return result;
    }

    public Comparable[] sort() {
        Comparable[] result = new Comparable[size];
        Comparable[] clone = values.clone();

        while (size > 0) {
            swap(1, size--);
            sink(1);
        }
        for (int i = 0; i < result.length; i++)
            result[i] = values[i + 1];

        this.values = clone;
        size = values.length - 1;
        return result;
    }

    private void sink(int k) {
        while (2 * k <= size) {
            if (2 * k + 1 <= size && less(2 * k, 2 * k + 1) && less(k, 2 * k + 1)) {
                swap(k, 2 * k + 1);
                k = 2 * k + 1;
            } else if (less(k, 2 * k)) {
                swap(k, 2 * k);
                k = 2 * k;
            } else {
                break;
            }
        }
    }

    private boolean less(int i, int j) {
        return values[i].compareTo(values[j]) < 0;
    }

    private void swim(int k) {
        while (k / 2 > 0) {
            if (less(k, k / 2)) break;
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void swap(int i, int j) {
        Comparable tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
}
