package algo.practice.utils;

/**
 * Created by Hey on 13/9/15
 * <p>
 * ------------------------
 * <p>
 * A very simple heap (can be used as a priority queue)
 */
public abstract class AbstractSimpleHeap<T extends Comparable<T>> implements SimpleHeap<T> {

    private int size = 0;

    //    Again size is computed recursively, may be inefficient
//    public int size() {
//        return (value.isPresent() ? 1 : 0) + getChildrenSize(left) + getChildrenSize(right);
//    }
    @Override
    public int size() {
        return size;
    }

    protected void changeSizeBy(int delta) {
        size += delta;
    }

    protected void incrementSizeByOne() {
        changeSizeBy(1);
    }

    protected void decrementSizeByOne() {
        changeSizeBy(-1);
    }

    protected abstract AbstractSimpleHeap<T> createEmptyHeap();
    protected abstract AbstractSimpleHeap<T> createHeap(T node);

    @Override
    public boolean isEmpty() {
//        return !value.isPresent();
        return size==0;
    }


    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is Empty");
        } else {
            return getValue();
        }
    }

    public abstract T getValue() ;

    public abstract void setValue(T value);

}
