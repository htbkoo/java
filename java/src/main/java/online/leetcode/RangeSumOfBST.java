package online.leetcode;

/*

https://leetcode.com/problems/range-sum-of-bst/

Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.



Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32

Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23



Note:

    The number of nodes in the tree is at most 10000.
    The final answer is guaranteed to be less than 2^31.

*/

import online.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class RangeSumOfBST {
    static class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            return 0;
        }

        public int rangeSumBSTIterative(TreeNode root, int L, int R) {
            if (root == null) {
                return 0;
            } else {
                int sum = 0;
                Deque<TreeNode> queue = new ArrayDeque<>();
                queue.add(root);

                while (!queue.isEmpty()) {
                    TreeNode current = queue.poll();
                    if (L <= current.val && current.val <= R) {
                        sum += current.val;
                    }
                    if (L < current.val && current.left != null) {
                        queue.add(current.left);
                    }
                    if (current.val < R && current.right != null) {
                        queue.add(current.right);
                    }
                }

                return sum;
            }
        }

        public int rangeSumBSTRecursive(TreeNode root, int L, int R) {
            if (root == null) {
                return 0;
            } else {
                int sum = 0;
                if (L <= root.val && root.val <= R) {
                    sum += root.val;
                }
                if (L < root.val) {
                    sum += rangeSumBSTRecursive(root.left, L, R);
                }
                if (R > root.val) {
                    sum += rangeSumBSTRecursive(root.right, L, R);
                }
                return sum;
            }
        }
    }
}
