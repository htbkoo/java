package online.leetcode;

import online.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Hey on 23/1/16
 */
/*

https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

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

public class BinaryTreeLevelOrderTraversalII {
    //         2ms
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> levelOrder = new ArrayList<>();

        TreeNode[] row = new TreeNode[1];
        int pointer = 0;
        levelOrder.add(Collections.singletonList(root.val));
        row[pointer++] = root;

        while (pointer > 0) {
            TreeNode[] prevRow = row;
            final int lastRowLength = pointer;
            row = new TreeNode[pointer * 2];
            pointer = 0;
            List<Integer> rowVal = new ArrayList<>();
            for (int i = 0; i < lastRowLength; ++i) {
                TreeNode node = prevRow[i];
                if (node.left != null) {
                    rowVal.add(node.left.val);
                    row[pointer++] = node.left;
                }
                if (node.right != null) {
                    rowVal.add(node.right.val);
                    row[pointer++] = node.right;
                }
            }
            if (!rowVal.isEmpty()) {
                levelOrder.add(rowVal);
            }
        }

        Collections.reverse(levelOrder);
        return levelOrder;
    }

    private class SlowApproachUsingCollection {
        //        4ms
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<List<Integer>> levelOrder = new ArrayList<>();
            List<TreeNode> row = new ArrayList<>();

            levelOrder.add(Collections.singletonList(root.val));
            row.add(root);

            while (!row.isEmpty()) {
                List<TreeNode> prevRow = row;
                row = new ArrayList<>();
                List<Integer> rowVal = new ArrayList<>();
                for (TreeNode node : prevRow) {
                    if (node.left != null) {
                        rowVal.add(node.left.val);
                        row.add(node.left);
                    }
                    if (node.right != null) {
                        rowVal.add(node.right.val);
                        row.add(node.right);
                    }
                }
                if (!rowVal.isEmpty()) {
                    levelOrder.add(rowVal);
                }
            }

            Collections.reverse(levelOrder);

            return levelOrder;
        }
    }
}
