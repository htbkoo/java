package algo.practice.ds.tree;

import java.util.function.Function;

/**
 * Created by Hey on 3 Aug 2016
 */
public class SimpleBinarySearchTree<T extends Comparable<? super T>> extends AbstractBinaryTree<T> {

    @Override
    public boolean isExist(T target) {
        if (value == null) {
            return false;
        }
        if (value.equals(target)) {
            return true;
        }

        final Function<SimpleBinarySearchTree<T>, Boolean> checkIfExistFor
                = (tree) -> (tree != null) && (tree.isExist(target));
        return checkIfExistFor.apply(getTreeToApplyTargetTo(target));
    }

    @Override
    protected void binaryTreeInsert(T target) {
        if (value == null) {
            value = target;
            if (left == null) {
                left = new SimpleBinarySearchTree<>();
            }
            if (right == null) {
                right = new SimpleBinarySearchTree<>();
            }
        } else {
            getTreeToApplyTargetTo(target).binaryTreeInsert(target);
        }
    }

    @Override
    protected void binaryTreeDelete(T target) {
        final SimpleBinarySearchTree<T> targetNode = findTargetNode(target);
        targetNode.recursivelyPerformDelete();
    }

    @Override
    protected boolean hasNoChildren() {
        return (left.value == null) && (right.value == null);
    }

    private SimpleBinarySearchTree<T> getTreeToApplyTargetTo(T target) {
        switch (value.compareTo(target)) {
            case 0:
                return (SimpleBinarySearchTree<T>) left;
            case -1:
                return (SimpleBinarySearchTree<T>) right;
            case 1:
                return (SimpleBinarySearchTree<T>) left;
        }
        throw new IllegalStateException("Could not reach here unless the implementation for compareTo() has changed");
    }

    private void recursivelyPerformDelete() {
        if (hasNoChildren()) {
            value = null;
        } else {
            final Function<SimpleBinarySearchTree<T>, Void> replaceByChild = (child) -> {
                this.value = child.value;
                this.left = child.left;
                this.right = child.right;
                return null;
            };
            if (left.value == null) {
                replaceByChild.apply((SimpleBinarySearchTree<T>) right);
            } else if (right.value == null) {
                replaceByChild.apply((SimpleBinarySearchTree<T>) left);
            } else {
//                With 2 children
//                simple implementation - always find in order predecessor
                SimpleBinarySearchTree<T> parent = this.findParentOfInOrderPredecessor();
                this.value = parent.right.value;
                parent.right = parent.right.left;
            }
        }
    }

    private SimpleBinarySearchTree<T> findParentOfInOrderPredecessor() {
        AbstractBinaryTree<T> parent = this;
        AbstractBinaryTree<T> cur = this.left;
        while (cur.right.value != null) {
            parent = cur;
            cur = cur.right;
        }
        return (SimpleBinarySearchTree<T>) parent;
    }

    private SimpleBinarySearchTree<T> findTargetNode(T target) {
        if (value == null) {
            throw new IllegalArgumentException(String.format("Target %s not found in the tree!", target));
        } else {
            if (value.equals(target)) {
                return this;
            }
            return getTreeToApplyTargetTo(target).findTargetNode(target);
        }
    }

}
