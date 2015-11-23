package online.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Hey on 23/11/15
 */

/*

https://leetcode.com/problems/implement-stack-using-queues/

 Implement the following operations of a stack using queues.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    empty() -- Return whether the stack is empty.

Notes:

    You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
    Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
    You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

Update (2015-06-11):
The class name of the Java function had been updated to MyStack instead of Stack.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and all test cases.

Subscribe to see which companies asked this question


*/

class MyStack {
    private Deque<Integer> queue1 = new ArrayDeque<>();
    private Deque<Integer> queue2 = new ArrayDeque<>();

    // Push element x onto stack.
    public void push(int x) {
        queue1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        moveToQueue2ExceptLast(1);
        queue1.poll();
        swapQueues();
    }

    // Get the top element.
    public int top() {
        moveToQueue2ExceptLast(1);
        return queue1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    private void moveToQueue2ExceptLast(int amount) {
        while (queue1.size() > amount) {
            queue2.add(queue1.poll());
        }
    }

    private void swapQueues() {
        Deque<Integer> tempQueue = queue1;
        queue1 = queue2;
        queue2 = tempQueue;
    }
}
