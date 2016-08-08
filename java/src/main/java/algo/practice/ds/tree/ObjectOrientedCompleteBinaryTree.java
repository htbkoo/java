package algo.practice.ds.tree;

/**
 * Created by Hey on 3 Aug 2016
 */
@SuppressWarnings("WeakerAccess")
public class ObjectOrientedCompleteBinaryTree<T> extends AbstractBinaryTree<T> {

    @Override
    public boolean isExist(T target) {
        if (target.equals(value)) {
            return true;
        }
        final boolean leftExist = (left != null) && left.isExist(target);
        final boolean rightExist = right != null && right.isExist(target);
        return leftExist || rightExist;
    }

    @Override
    public void binaryTreeInsert(T target) {
        if (value == null) {
            value = target;
        } else if (left == null) {
            left = new ObjectOrientedCompleteBinaryTree<>();
            left.insert(target);
        } else if (right == null) {
            right = new ObjectOrientedCompleteBinaryTree<>();
            right.insert(target);
        } else {
            getChildSide().insert(target);
        }
    }

    private AbstractBinaryTree<T> getChildSide() {
        final int numNodes = getNumNodes();

        final int targetSize = size() + 1;

        if (targetSize >= numNodes + numNodes / 2) {
            return right;
        } else {
            return left;
        }
    }

    private int getNumNodes() {
//        return (int) (Math.log(size()) / Math.log(2));
        if (size() == 0) {
            return 0;
        }

        int node = 2;
        while (node <= size()) {
            if (2 * node < node) {
                throw new IllegalStateException("number of nodes overflew!");
            }
            node = 2 * node;
        }
        return node / 2;
    }


    @Override
    public void delete(T target) {
        throw new UnsupportedOperationException("Delete is unsupported for complete binary tree yet");
    }

    @Override
    protected void binaryTreeDelete(T target) {
        throw new UnsupportedOperationException("Delete is unsupported for complete binary tree yet");
    }

    @SuppressWarnings("unused")
    private int naiveCalculateSize() {
        if (value == null) {
            return 0;
        } else if (left == null) {
            return 1;
        } else if (right == null) {
            return 1 + left.size();
        } else {
            return 1 + left.size() + right.size();
        }
    }

    @SuppressWarnings("unused")
    private int naiveCalculateHeight() {
        if (value == null) {
            return 0;
        } else if ((left == null) && (right == null)) {
            return 1;
        } else if ((left != null) && (right != null)) {
            return Math.max(((ObjectOrientedCompleteBinaryTree) left).naiveCalculateHeight(), ((ObjectOrientedCompleteBinaryTree) right).naiveCalculateHeight()) + 1;
        } else if (left != null) {
            return ((ObjectOrientedCompleteBinaryTree) left).naiveCalculateHeight() + 1;
        } else {
            return ((ObjectOrientedCompleteBinaryTree) right).naiveCalculateHeight() + 1;
        }
    }

    @SuppressWarnings("unused")
    private boolean isPerfect() {
        if (value == null) {
            return true;
        } else if ((left == null) && (right == null)) {
            return true;
        } else if ((left != null) && (right != null)) {
            return ((ObjectOrientedCompleteBinaryTree) left).isPerfect() && ((ObjectOrientedCompleteBinaryTree) right).isPerfect();
        }
        return false;
    }

    @SuppressWarnings("unused")
    private HeightAndCorrespondingNumNodes getHeightAndCorrespondingNumNodes() {
//        return (int) (Math.log(size()) / Math.log(2));
        if (size() == 0) {
            return new HeightAndCorrespondingNumNodes(0, 0);
        }

        int height = 1;
        int node = 2;
        while (node <= size()) {
            ++height;
            if (2 * node < node) {
                throw new IllegalStateException("number of nodes overflew!");
            }
            node = 2 * node;
        }
        return new HeightAndCorrespondingNumNodes(height, node / 2);
    }

    private class HeightAndCorrespondingNumNodes {
        final int height, numNodes;

        private HeightAndCorrespondingNumNodes(int height, int numNodes) {
            this.height = height;
            this.numNodes = numNodes;
        }
    }
}
