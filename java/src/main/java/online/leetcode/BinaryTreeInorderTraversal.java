package online.leetcode;

/**
 * Created by Hey on 19/12/15
 */

/*

https://leetcode.com/problems/binary-tree-inorder-traversal/

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Subscribe to see which companies asked this question

*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> rightStack = new ArrayDeque<>();

        TreeNode current = root;

        if (current == null) {
            return result;
        }

        stack.push(current);
        while ((!stack.isEmpty()) || (!rightStack.isEmpty())) {
            if (!stack.isEmpty()) {
                current = stack.pop();
                rightStack.push(current);
                if (current.left != null) {
                    stack.push(current.left);
                }
            } else {
                current = rightStack.pop();
                result.add(current.val);
                if (current.right != null) {
                    stack.push(current.right);
                }
            }
        }

        return result;
    }

    private class RecursionApproachInOrder {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) {
                return result;
            }

            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));

            return result;
        }
    }
}
