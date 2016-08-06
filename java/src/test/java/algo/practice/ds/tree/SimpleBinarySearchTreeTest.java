package algo.practice.ds.tree;

/**
 * Created by Hey on 3 Aug 2016
 */
public abstract class SimpleBinarySearchTreeTest<T extends Comparable<? super T>> extends TreeTest<T> {
    protected Tree<T> getTree() {
        return new SimpleBinarySearchTree<>();
    }
}