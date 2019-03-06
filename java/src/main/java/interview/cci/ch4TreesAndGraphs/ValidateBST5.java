package interview.cci.ch4TreesAndGraphs;

import interview.cci.ch4TreesAndGraphs.util.TreeNode;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

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
    private static final boolean UNBOUNDED_IS_ALWAYS_VALID = true;

    public boolean isValid(TreeNode root) {
        if (root == null) {
            return ASSUME_EMPTY_TREE_IS_VALID;
        } else {
            return isValid(root, empty(), empty());
        }
    }

    private boolean isValid(TreeNode node, Optional<Integer> lo, Optional<Integer> hi) {
        if (node == null) {
            return true;
        } else {
            final int val = node.val;
            return isWithInRange(val, lo, hi) && isValid(node.left, lo, of(val)) && isValid(node.right, of(val), hi);
        }
    }

    private boolean isWithInRange(int val, Optional<Integer> optionalLo, Optional<Integer> optionalHi) {
        return optionalLo.map(lo -> lo < val).orElse(UNBOUNDED_IS_ALWAYS_VALID) && optionalHi.map(hi -> val < hi).orElse(UNBOUNDED_IS_ALWAYS_VALID);
    }
}
