package online.leetcode;

import online.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Hey on 16/1/16
 */

/*

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

//    Binary Search Tree Iterator

public class BSTIterator {
    TreeNode next;
    Deque<TreeNode> ancestorsStack;

    public BSTIterator(TreeNode root) {
        ancestorsStack = new ArrayDeque<>();
        addToAncestorsStackUntilSmallest(root);
    }

    private void addToAncestorsStackUntilSmallest(TreeNode current) {
        while (current!=null) {
            ancestorsStack.push(current);
            current=current.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
//        if (!ancestorsStack.isEmpty())
//            return false;
        return !ancestorsStack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        final TreeNode smallest = ancestorsStack.pop();
        addToAncestorsStackUntilSmallest(smallest.right);
        return smallest.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */