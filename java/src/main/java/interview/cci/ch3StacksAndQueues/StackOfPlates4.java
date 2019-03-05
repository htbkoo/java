package interview.cci.ch3StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackOfPlates4 {
    public static class SetOfStacks<T> {
        private final int capacity;
        private final Deque<Deque<T>> stacks;

        public SetOfStacks(int capacity) {
            this.capacity = capacity;
            stacks = new ArrayDeque<>();
        }

        public void push(T item) {
            if (isEmpty() || isTopStackFull()) {
                stacks.push(new ArrayDeque<>());
            }
            // Impossible, new deque would be created if stacks is empty
            //noinspection ConstantConditions
            stacks.peek().push(item);
        }

        private boolean isTopStackFull() {
            if (stacks.isEmpty()) {
                throw new IllegalStateException("Defect: stack is empty when calling isTopStackFull()");
            } else {
                return stacks.peek().size() >= capacity;
            }
        }

        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            } else {
                final Deque<T> topStack = stacks.peek();
                // Impossible, already check stacks is not empty
                //noinspection ConstantConditions
                if (topStack.size() <= 1) {
                    stacks.pop();
                }
                return topStack.pop();
            }
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            } else {
                // Impossible, already check stacks is not empty
                //noinspection ConstantConditions
                return stacks.peek().peek();
            }
        }

        public boolean isEmpty() {
            return stacks.isEmpty();
        }

        public int numStacks() {
            return stacks.size();
        }
    }
}
