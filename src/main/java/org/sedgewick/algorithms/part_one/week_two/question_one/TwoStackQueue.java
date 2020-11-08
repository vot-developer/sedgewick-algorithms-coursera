package org.sedgewick.algorithms.part_one.week_two.question_one;

import java.util.Stack;

public class TwoStackQueue  {
    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> peekStack = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public TwoStackQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (pushStack.empty() && peekStack.empty())
            return -1;

        if (peekStack.empty()){
            while (!pushStack.empty()){
                peekStack.push(pushStack.pop());
            }
        }

        return peekStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (pushStack.empty() && peekStack.empty())
            return -1;

        if (peekStack.empty()) {
            while (!pushStack.empty()) {
                peekStack.push(pushStack.pop());
            }
        }

        return peekStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return pushStack.empty() && peekStack.empty();
    }
}
