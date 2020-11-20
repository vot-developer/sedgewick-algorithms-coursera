package org.sedgewick.algorithms.part_one.week_two.assigment_one;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    void testQueue() {
        Deque<Integer> deque = new Deque<>();
        assertTrue(deque.isEmpty());
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(3, deque.size());
        assertEquals(1, deque.removeFirst());
        assertEquals(2, deque.removeFirst());
        assertEquals(1, deque.size());
        assertEquals(3, deque.removeFirst());
        assertEquals(0, deque.size());
    }

    @Test
    void testStack() {
        Deque<Integer> deque = new Deque<>();
        assertTrue(deque.isEmpty());
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertEquals(3, deque.size());
        assertEquals(1, deque.removeLast());
        assertEquals(3, deque.removeFirst());
        assertEquals(1, deque.size());
    }

    @Test
    void testScenario() {
        Deque<Integer> deque = new Deque<>();
        assertTrue(deque.isEmpty());
        deque.addLast(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addFirst(4);
        assertEquals(2, deque.removeLast());
        deque.addFirst(4);
        assertEquals(4, deque.removeFirst());
    }

    @Test
    void testEmpty() {
        Deque<Integer> deque = new Deque<>();
        assertTrue(deque.isEmpty());
        deque.addLast(1);
        assertEquals(1, deque.removeFirst());
        assertThrows(NoSuchElementException.class, () -> {
            deque.removeLast();
        });
    }

    @Test
    void iteratorTest() {
        Deque<Integer> deque = new Deque<>();
        assertTrue(deque.isEmpty());
        deque.addLast(1);
        deque.addLast(2);
        deque.addFirst(3);
        StringBuilder sb = new StringBuilder();
        for (Integer i : deque) {
            sb.append(i);
        }
        assertEquals("312", sb.toString());
    }

    @Test
    void testIteratorPlain() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        Iterator<Integer> it = deque.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertFalse(it.hasNext());
    }
}