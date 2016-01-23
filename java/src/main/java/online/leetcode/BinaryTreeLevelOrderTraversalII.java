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
