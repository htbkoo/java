package online.leetcode;

import online.leetcode.util.TreeNode;

/**
 * Created by Hey on 13/10/15
 */

/*

https://leetcode.com/problems/same-tree/

Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

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
public class SameTree {
    //        check if java short circuit
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        return q != null && (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}