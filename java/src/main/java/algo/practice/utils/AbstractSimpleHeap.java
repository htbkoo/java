package algo.practice.utils;

/**
 * Created by Hey on 13/9/15
 * <p>
 * ------------------------
 * <p>
 * A very simple heap (can be used as a priority queue)
 */
public abstract class AbstractSimpleHeap<T extends Comparable<T>> implements SimpleHeap<T> {
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is Empty");
        } else {
            return getValue();
        }
    }

    protected abstract boolean currentIsTopper(T current, T comp);

    public abstract T getValue() ;

    public abstract void setValue(T value);

    public abstract boolean isEmpty();
}
