package online.leetcode;

import online.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hey on 9/1/16
 */

/*

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

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

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int height = 0;
        int numChildren = 0;
        TreeNode[] thisLevel;
        TreeNode[] nextLevel = new TreeNode[2*height+1];
        nextLevel[numChildren] = root;
        ++numChildren;
        while (numChildren>0) {
            thisLevel = nextLevel;
            ++height;
            numChildren = 0;
            nextLevel = new TreeNode[2*height+1];
            for (TreeNode node : thisLevel) {
                if (node==null){
                    break;
                }
                if ((node.left == null) && (node.right == null)) {
                    return height;
                }
                if (node.left != null) {
                    nextLevel[numChildren] = node.left;
                    ++numChildren;
                }
                if (node.right != null) {
                    nextLevel[numChildren] = node.right;
                    ++numChildren;
                }
            }
        }
        return height;
    }

    private class SlowUsingObjectADT {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            int height = 0;

            List<TreeNode> thisLevel;
            List<TreeNode> nextLevel = new ArrayList<>();
            nextLevel.add(root);
            while (!nextLevel.isEmpty()) {
                thisLevel = nextLevel;
                ++height;
                nextLevel = new ArrayList<>();
                for (TreeNode node : thisLevel) {
                    if ((node.left == null) && (node.right == null)) {
                        return height;
                    }
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                }
            }
            return height;
        }
    }
}
