package algo.practice.utils;

import com.sun.istack.internal.NotNull;

import java.util.Optional;

/**
 * Created by Hey on 13/9/15
 */
public class SimpleMinBinaryHeap<T extends Comparable<T>> extends AbstractSimpleHeap<T> {
    private Optional<? extends T> value = Optional.empty();
    private Optional<SimpleMinBinaryHeap<T>> left = Optional.empty(), right = Optional.empty();

    private int size = 0;

    public SimpleMinBinaryHeap(T node) {
        super();
        push(node);
    }

    public SimpleMinBinaryHeap() {
        super();
    }

    @Override
    public T pop() {
        size--;
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public void push(@NotNull T node) {
        if (value.isPresent()) {
            if (left.isPresent()) {
                SimpleMinBinaryHeap<T> leftHeap = left.get();
                if (right.isPresent()) {
                    SimpleMinBinaryHeap<T> rightHeap = right.get();
                    if (!keepTop(node)) {
                        T temp = node;
                        node = getValue();
                        value = Optional.of(temp);
                    }
                    if (leftHeap.size() <= rightHeap.size()) {
                        leftHeap.push(node);
                    } else {
                        rightHeap.push(node);
                    }
                } else {
                    right = Optional.of(new SimpleMinBinaryHeap<>(node));
                }
            } else {
                left = Optional.of(new SimpleMinBinaryHeap<>(node));
            }
        } else {
            setValue(node);
        }

        size++;
    }

    private boolean keepTop(T node) {
        return getValue().compareTo(node) <= 0;

    }

    //    The name is to be refactored to be a more meaningful one
    @Override
    protected boolean currentIsTopper(T current, T comp) {
        return current.compareTo(comp) < 0;
    }

    @Override
    public void replaceRoot(T node) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    //    Again size is computed recursively, may be inefficient
//    public int size() {
//        return (value.isPresent() ? 1 : 0) + getChildrenSize(left) + getChildrenSize(right);
//    }

    //    With cached size
    public int size() {
        return size;
    }

    private int getChildrenSize(Optional<SimpleMinBinaryHeap<T>> child) {
        return child.isPresent() ? child.get().size() : 0;
    }

    @Override
    public T getValue() {
        return value.get();
    }

    @Override
    public void setValue(T value) {
        this.value = Optional.of(value);
    }

    public boolean isEmpty() {
        return !value.isPresent();
    }
}
