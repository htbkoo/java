package online.leetcode;

import online.leetcode.util.TreeNode;

/**
 * Created by Hey on 12/12/15
 */

/*

https://leetcode.com/problems/balanced-binary-tree/

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Subscribe to see which companies asked this question

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class BalancedBinaryTree {
    private class FailedAttempt {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (root.left == null) {
                return root.right == null || !hasChild(root.right);
            } else {
                if (root.right == null) {
                    return !hasChild(root.left);
                } else {
                    return isBalanced(root.left) && isBalanced(root.right);
                }
            }
        }

        private boolean hasChild(TreeNode node) {
            return (node.left != null) || (node.right != null);
        }
    }

    private final static TreeStatus IMBALANCED_TREE = new TreeStatus(0, false);

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeStatus leftTree = getTreeStatus(root.left);
        TreeStatus rightTree = getTreeStatus(root.right);

        return leftTree.isBalanced && rightTree.isBalanced && (Math.abs(leftTree.height - rightTree.height) <= 1);
    }

    private TreeStatus getTreeStatus(TreeNode treeNode) {
        if (treeNode == null) {
            return new TreeStatus(0, true);
        }

        TreeStatus leftTree = getTreeStatus(treeNode.left);
        if (!leftTree.isBalanced) {
            return IMBALANCED_TREE;
        }
        TreeStatus rightTree = getTreeStatus(treeNode.right);
        if (!rightTree.isBalanced) {
            return IMBALANCED_TREE;
        }

//      Condition 'leftTree.isBalanced' is always 'true'
//      Condition 'rightTree.isBalanced' is always 'true'
//        final boolean isBalanced = leftTree.isBalanced && rightTree.isBalanced && (Math.abs(leftTree.height - rightTree.height) <= 1);
        final boolean isBalanced = Math.abs(leftTree.height - rightTree.height) <= 1;
        if (isBalanced) {
            final int height = Math.max(leftTree.height, rightTree.height) + 1;
            return new TreeStatus(height, true);
        } else {
            return IMBALANCED_TREE;
        }
    }

    private static class TreeStatus {
        final int height;
        final boolean isBalanced;

        private TreeStatus(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

}
