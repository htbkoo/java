package algo.practice.ds.tree;

/**
 * Created by Hey on 3 Aug 2016
 */
public abstract class AbstractBinaryTree<T> implements Tree<T> {
    protected AbstractBinaryTree<T> left;
    protected AbstractBinaryTree<T> right;
    protected T value;

    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(T target) {
        binaryTreeInsert(target);
        ++size;
    }

    protected abstract void binaryTreeInsert(T target);

    @Override
    public void delete(T target) {
        binaryTreeDelete(target);
        --size;
    }

    protected abstract void binaryTreeDelete(T target);

    protected boolean hasNoChildren() {
        return (left == null) && (right == null);
    }
}
