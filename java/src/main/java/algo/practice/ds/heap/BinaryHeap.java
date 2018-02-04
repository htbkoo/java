package algo.practice.ds.heap;

import java.util.ArrayList;
import java.util.function.Function;

public class BinaryHeap<T extends Comparable<? super T>> implements Heap<T> {
    private ArrayList<T> list = new ArrayList<>();

    @Override
    public void insert(T item) {
        list.add(item);
        final int position = getLastPosition();
        heapify(position, this::getParentPosition);
    }

    @Override
    public T peek() {
        return list.get(0);
    }

    @Override
    public T pop() {
        final T topItem = list.get(0);

        final int lastPosition = getLastPosition();

        swap(0, lastPosition);
        list.remove(lastPosition);

        pushDown(0);

        return topItem;
    }

    private void pushDown(int position) {
        if (hasChild(position)) {
            final int betterChildrenPosition = findBetterChildrenPosition(position);
            if (isOrderWrong(betterChildrenPosition, position)) {
                swap(betterChildrenPosition, position);
                pushDown(betterChildrenPosition);
            }
        }
    }

    private boolean hasChild(int position) {
        return list.size() > (position * 2 + 1);
    }

    private int findBetterChildrenPosition(int position) {
        final int leftPosition = position * 2 + 1, rightPosition = position * 2 + 2;
        final boolean hasRightChild = list.size() > (position * 2 + 2);

        if (!hasRightChild) {
            return leftPosition;
        } else {
            final boolean isLeftSmaller = list.get(leftPosition).compareTo(list.get(rightPosition)) <= 0;
            if (isLeftSmaller) {
                return leftPosition;
            } else {
                return rightPosition;
            }
        }
    }

    @Override
    public int size() {
        return 0;
    }

    private int getLastPosition() {
        return list.size() - 1;
    }

    private void heapify(int position, Function<Integer, Integer> nextPositionSupplier) {
        int nextPosition = nextPositionSupplier.apply(position);
        if (isOrderWrong(position, nextPosition)) {
            swap(position, nextPosition);
            heapify(nextPosition, nextPositionSupplier);
        }
    }

    private int getParentPosition(int position) {
        return (position - 1) / 2;
    }

    private boolean isOrderWrong(int position, int parentPosition) {
        final T item = list.get(position), parent = list.get(parentPosition);
        return item.compareTo(parent) < 0;
    }

    private void swap(int position, int parentPosition) {
        final T item = list.get(position), parent = list.get(parentPosition);
        list.set(position, parent);
        list.set(parentPosition, item);
    }

}
