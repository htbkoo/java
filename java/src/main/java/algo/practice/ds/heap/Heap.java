package algo.practice.ds.heap;

public interface Heap<T extends Comparable<? super T>> {
    void insert(T item);

    T peek();

    T pop();

    int size();
}
