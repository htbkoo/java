package algo.practice.ds.tree;

/**
 * Created by Hey on 3 Aug 2016
 */
public abstract class ObjectOrientedCompleteBinaryTreeTest<T> extends TreeTest<T> {
    protected Tree<T> getTree() {
        return new ObjectOrientedCompleteBinaryTree<>();
    }
}