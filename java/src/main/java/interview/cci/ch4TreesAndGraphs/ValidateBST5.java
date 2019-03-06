package interview.cci.ch4TreesAndGraphs;

import interview.cci.ch4TreesAndGraphs.util.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class ValidateBST5 {
    private static final boolean ASSUME_EMPTY_TREE_IS_VALID = true;

    public boolean isValid(TreeNode root) {
        if (root == null) {
            return ASSUME_EMPTY_TREE_IS_VALID;
        } else {
            return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
    }

    private boolean isValid(TreeNode node, long lo, long hi) {
        if (node == null) {
            return true;
        } else {
            final int val = node.val;
            return isWithInRange(val, lo, hi) && isValid(node.left, lo, val) && isValid(node.right, val, hi);
        }
    }

    private boolean isWithInRange(int val, long lo, long hi) {
        return lo < val && val < hi;
    }
}
