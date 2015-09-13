package algo.practice.ds;

import algo.practice.utils.Node;

import java.util.ListIterator;
import java.util.Optional;

/**
 * Created by Hey on 9/9/15.
 */
public class PracticeSinglyLinkedList<K>
//extends AbstractSequentialList<K>
{
    PracticeSinglyLinkedListIterator practiceSinglyLinkedListIterator;
    private Optional<Node<? extends K>> head;

    public PracticeSinglyLinkedList() {
        this.head = Optional.empty();
    }

    public PracticeSinglyLinkedList(Node<? extends K> head) {
        this.head = Optional.ofNullable(head);
    }


    public boolean isEmpty() {
        return !head.isPresent();
    }

    //    @Override
    public ListIterator listIterator(int index) {
        return null;
//        return new ;
    }

    //    @Override
    public int size() {
        return 0;
    }

    public K getHead() {
        return Node.defensiveCopyNode(head.get()).getValue();
    }

    public void setHead(K head) {
        this.head = Optional.ofNullable(Node.<K>createNode(head));
    }

    private class PracticeSinglyLinkedListIterator implements ListIterator<K> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public K next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            throw new RuntimeException("Forward operation Not supported by singly linked list.");
        }

        @Override
        public K previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(K k) {

        }

        @Override
        public void add(K k) {

        }
    }

    private String buildAllContent() {
        StringBuilder builder = new StringBuilder();
        Node<? extends K> current = head.get();
        builder.append(head.get().getValue().toString());
        while (current.hasNext()) {
            current = current.getNext();
            builder.append(String.format(", %s", current.getValue().toString()));
        }
        return builder.toString();
    }


    @Override
    public String toString() {
        if (head.isPresent()) {
            return "PracticeSinglyLinkedList{ " +
                    head.get().toString() +
                    ", all content = {" + buildAllContent() +
                    "}" +
                    '}';
        } else {
            return "PracticeSinglyLinkedList{ }";
        }
    }
}