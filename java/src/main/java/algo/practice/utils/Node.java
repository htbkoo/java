package algo.practice.utils;

import com.google.common.collect.Iterables;

import java.util.Iterator;
import java.util.Optional;

/**
 * Created by Hey on 12/9/15.
 */
public class Node<T> {
    Optional<Node<? extends T>> next = Optional.empty();
    T value;

    private Node(Optional<Node<? extends T>> next, T value) {
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

    public static <T> Node<? extends T> createNodes(Iterable<T> values) {
        Iterator<T> valuesIterator = values.iterator();
        if (!valuesIterator.hasNext()) {
            throw new IllegalArgumentException("valus is empty");
        } else {
            T first = valuesIterator.next();
            if (!valuesIterator.hasNext()) {
                return createNode(first);
            } else {
                Node<? extends T> next = createNodes(Iterables.skip(values, 1));
                return new Node<>(Optional.of(next), valuesIterator.next());
            }
        }
    }


}

