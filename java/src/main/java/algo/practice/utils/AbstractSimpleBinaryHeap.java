package algo.practice.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

/**
 * Created by Hey on 16/9/15
 */
public abstract class AbstractSimpleBinaryHeap<T extends Comparable<T>> extends AbstractSimpleHeap<T> {
    private static Logger logger = LogManager.getLogger(AbstractSimpleBinaryHeap.class);

    protected Optional<AbstractSimpleBinaryHeap<T>> left = Optional.empty();
    protected Optional<AbstractSimpleBinaryHeap<T>> right = Optional.empty();

    @Override
    public void push(T node) {
        logger.info(String.format("Starting to push %s into the heap.", node));

        if (!isEmpty()) {
            if (!keepTop(node)) {
                logger.debug(String.format("Swapping top (%s) with %s.", getValue(), node));
                T temp = node;
                node = getValue();
                setValue(temp);
            }

            if (left.isPresent()) {
                AbstractSimpleBinaryHeap<T> leftHeap = left.get();
                if (right.isPresent()) {
                    AbstractSimpleBinaryHeap<T> rightHeap = right.get();
//                    Assumed order of filling heap is left-right
                    if (leftHeap.size() <= rightHeap.size()) {
                        logger.debug(String.format("Push %s to left child heap.", node));
                        leftHeap.push(node);
                    } else {
                        logger.debug(String.format("Push %s to right child heap.", node));
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

        logger.info("Push done, size++.");
        incrementSizeByOne();
    }


    // There is possibly some problem with this implementation which may result in performance issue due to the fact that
// under some worst case, the heap can degenerate (skew) into one side and become a list
// And with this implementation, it is not possible to avoid this problem without rebalancing.
    @Override
    public T pop() {
        logger.info("Starting to pop from the heap.");

        if (!isEmpty()) {
            T returnValue = getValue();
            logger.debug(String.format("Return value would be top = %s.", returnValue));

            if (left.isPresent()) {
                AbstractSimpleBinaryHeap<T> leftHeap = left.get();

                if (right.isPresent()) {
                    AbstractSimpleBinaryHeap<T> rightHeap = right.get();

                    T leftTop = leftHeap.peek();
                    T rightTop = rightHeap.peek();

                    if (leftIsTopper(leftTop, rightTop)) {
                        setValue(leftHeap.pop());
                        logger.debug(String.format("Replacing top value by the top value of the left child, which is now %s.", getValue()));
                    } else {
                        setValue(rightHeap.pop());
                        logger.debug(String.format("Replacing top value by the top value of the right child, which is now %s.", getValue()));
                    }

// May not need loop  - every pop() operation only alter size by 1, and we do rebalancing everytime
//                    while (childrenSizeDiff(leftHeap.size(), rightHeap.size()) >= 2) {
                    int childrenSizeDiff = childrenSizeDiff(leftHeap.size(), rightHeap.size());
                    if (childrenSizeDiff > 1) {
                        logger.info(String.format("Children size diff is %s, performing rebalancing.", childrenSizeDiff));
                        rebalanceHeap(leftHeap, rightHeap);
                    }

                    if (rightHeap.size() == 0) {
                        logger.debug("Right child heap is empty, making it and empty Optional.");
                        right = Optional.empty();
                    }

                } else {
                    setValue(leftHeap.pop());

                    if (leftHeap.size() == 0) {
                        logger.debug("Left child heap is empty, making it and empty Optional.");
                        left = Optional.empty();
                    }

                }
            }


            logger.info(String.format("Popping %s, size--.", returnValue));
            decrementSizeByOne();
            return returnValue;
        } else {
            throw new IllegalStateException("Heap is Empty");
        }
    }

    private int childrenSizeDiff(final int leftHeapSize, final int rightHeapSize) {
        return Math.abs(leftHeapSize - rightHeapSize);
    }

    private void rebalanceHeap(final AbstractSimpleBinaryHeap<T> leftHeap, final AbstractSimpleBinaryHeap<T> rightHeap) {
        if (leftHeap.size() > rightHeap.size()) {
            rightHeap.push(leftHeap.pop());
        } else {
            leftHeap.push(rightHeap.pop());
        }
    }

    protected abstract boolean leftIsTopper(T leftTop, T rightTop);

    protected abstract boolean keepTop(T node);

    @Override
    protected abstract AbstractSimpleBinaryHeap<T> createEmptyHeap();

    @Override
    protected abstract AbstractSimpleBinaryHeap<T> createHeap(T node);

}
