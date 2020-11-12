package org.sedgewick.algorithms.part_one.week_three.question_three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShufflingLinkedListTest {

    @Test
    void test() {
        ShufflingLinkedList list = new ShufflingLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
        list.shuffle();
        list.print();
        list.shuffle();
        list.print();
        list.shuffle();
        list.print();
        list.shuffle();
        list.print();
    }
}