package algo.practice.ds.heap;

import java.util.ArrayList;

public class BinaryHeap<T extends Comparable<? super T>> implements Heap<T> {
    private ArrayList<T> list = new ArrayList<>();

    @Override
    public void insert(T item) {
        list.add(item);
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public T pop() {
        return list.remove(0);
    }

    @Override
    public int size() {
        return 0;
    }
}
