package online.hackerrank.interviewPreparationKit.Arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class QueuesATaleOfTwoStacks {
    public static class Solution {

        private static class MyQueue<T> {
            private final Deque<T> stackA = new ArrayDeque<>();
            private final Deque<T> stackB = new ArrayDeque<>();

            public void enqueue(T item) {
                stackA.push(item);
            }

            public T dequeue() {
                populateStackBIfNecessary();
                return stackB.pop();
            }

            private void populateStackBIfNecessary() {
                if (stackB.isEmpty()) {
                    if (stackA.isEmpty()) {
                        throw new IllegalStateException("Both stacks (i.e. the queue) are empty.");
                    } else {
                        while (!stackA.isEmpty()) {
                            stackB.push(stackA.pop());
                        }
                    }
                }
            }

            public T peek() {
                populateStackBIfNecessary();
                return stackB.peek();
            }
        }

        public static void main(String[] args) {
            MyQueue<Integer> queue = new MyQueue<Integer>();

            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();

            for (int i = 0; i < n; i++) {
                int operation = scan.nextInt();
                if (operation == 1) { // enqueue
                    queue.enqueue(scan.nextInt());
                } else if (operation == 2) { // dequeue
                    queue.dequeue();
                } else if (operation == 3) { // print/peek
                    System.out.println(queue.peek());
                }
            }
            scan.close();
        }
    }
}
