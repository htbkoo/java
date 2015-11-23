package online.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Hey on 23/11/15
 */

/*

https://leetcode.com/problems/implement-queue-using-stacks/

Implement Queue using Stacks

Implement the following operations of a queue using stacks.

    push(x) -- Push element x to the back of queue.
    pop() -- Removes the element from in front of queue.
    peek() -- Get the front element.
    empty() -- Return whether the queue is empty.

Notes:

    You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
    You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

Subscribe to see which companies asked this question

*/

class MyQueue {
    private Deque<Integer> inStack = new ArrayDeque<>();
    private Deque<Integer> outStack = new ArrayDeque<>();

    // Push element x to the back of queue.
    public void push(int x) {
        inStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (outStack.isEmpty()) {
            inToOutStack();
        }
        outStack.pop();
    }

    // Get the front element.
    public int peek() {
        if (outStack.isEmpty()) {
            inToOutStack();
        }
        return outStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void inToOutStack() {
        //    To be improved for push all
        while (!inStack.isEmpty()) {
            final Integer pop = inStack.pop();
            outStack.push(pop);
        }
    }
}
