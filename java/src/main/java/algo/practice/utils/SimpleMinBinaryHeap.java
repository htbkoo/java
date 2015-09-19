package algo.practice.utils;

import java.util.Optional;

/**
 * Created by Hey on 13/9/15
 */
public final class SimpleMinBinaryHeap<T extends Comparable<T>> extends AbstractSimpleBinaryHeap<T> {
    private Optional<? extends T> value = Optional.empty();

    public SimpleMinBinaryHeap(T node) {
        super();
        push(node);
    }

    public SimpleMinBinaryHeap() {
        super();
    }

    protected boolean leftIsTopper(T leftTop, T rightTop) {
        return leftTop.compareTo(rightTop) <= 0;

    }

    @Override
    public void replaceRoot(T node) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public T getValue() {
        return value.get();
    }

    @Override
    public void setValue(T value) {
        this.value = Optional.of(value);
    }

    @Override
    protected boolean keepTop(T node) {
        return getValue().compareTo(node) <= 0;
    }

    @Override
    protected AbstractSimpleBinaryHeap<T> createEmptyHeap() {
        return new SimpleMinBinaryHeap<>();
    }

    @Override
    protected AbstractSimpleBinaryHeap<T> createHeap(T node) {
        return new SimpleMinBinaryHeap<>(node);
    }

}
