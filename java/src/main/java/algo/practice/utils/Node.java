package algo.practice.utils;

import com.google.common.collect.Iterables;

import java.util.Iterator;
import java.util.Optional;

/**
 * Created by Hey on 12/9/15
 */
public class Node<T> {
    Optional<Node<? extends T>> next = Optional.empty();
    T value;

    private Node(Optional<Node<? extends T>> next, T value) {
        this.next = next;
        this.value = value;
    }

    private Node(Node<T> node) {
        this.next = node.next;
        this.value = node.value;
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

    public Node<? extends T> getNext() {
        if (hasNext())
            return next.get();
        else
            throw new IllegalStateException("No next node");
    }

    public void setNext(Node<? extends T> next) {
        this.next = Optional.of(next);
    }

    public static <T> Node<T> createNode(T value) {
        return new Node<>(Optional.<Node<? extends T>>empty(), value);
    }

    public static <T> Node<T> defensiveCopyNode(Node<T> node) {
        return new Node<>(node);
    }

    public static <T> Node<? extends T> createNodes(Iterable<? extends T> values) {
        Iterator<? extends T> valuesIterator = values.iterator();
        if (!valuesIterator.hasNext()) {
            throw new IllegalArgumentException("valus is empty");
        } else {
            T first = valuesIterator.next();
            if (!valuesIterator.hasNext()) {
                return createNode(first);
            } else {
                Node<? extends T> next = createNodes(Iterables.skip(values, 1));
                return new Node<>(Optional.of(next), first);
            }
        }
    }

//    toString is built recursively upon calling, may suffer from the bad O(n) performace
//    If this is needed frequently, it would be better to keep a cache of toString value in the list implementation and update upon any operation
    @Override
    public String toString() {
        String nextString;
        if (next.isPresent()) {
            nextString = next.get().toString();
        } else {
            nextString = "end";
        }
        return String.format("Node{value: %s} -> %s", value.toString(), nextString);
    }
}

