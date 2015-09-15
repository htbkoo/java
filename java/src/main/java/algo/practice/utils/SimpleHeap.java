package algo.practice.utils;

/**
 * Created by Hey on 13/9/15
 */
public interface SimpleHeap<T extends Comparable<T>> {
    T pop();

    T peek();

    void push(T node);

    void replaceRoot(T node);
}
