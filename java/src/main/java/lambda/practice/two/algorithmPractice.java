package lambda.practice.two;

import java.util.Optional;

/**
 * Created by Hey on 8/9/15.
 */
public class algorithmPractice {
    public class PracticeSinglyLinkedList<K> {
        private class Node<T> {
            Optional<Node<T>> next = Optional.empty();
            T value;

            public Node(Optional<Node<T>> next, T value) {
                this.next = next;
                this.value = value;
            }

            public T getValue() {
                return value;
            }

            public void setValue(T value) {
                this.value = value;
            }

            public boolean hasNext() {
                return next.isPresent();
            }

            public Node<T> getNext() {
                if (hasNext())
                    return next.get();
                else
                    throw new IllegalStateException("No next node");
            }

            public void setNext(Node<T> next) {
                this.next = Optional.of(next);
            }
        }

        public Node<K> createNode(K value) {
            return new Node<>(Optional.empty(), value);
        }

        public Node<K> createNode(Node<K> next, K value) {
            return new Node<>(Optional.of(next), value);
        }
    }


}
