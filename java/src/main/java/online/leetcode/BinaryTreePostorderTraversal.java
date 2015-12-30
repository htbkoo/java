package online.leetcode;

/**
 * Created by Hey on 27/12/15
 */

/*

https://leetcode.com/problems/binary-tree-postorder-traversal/

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

Subscribe to see which companies asked this question

*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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

// [6,2,7,1,4,null,9,null,null,3,5,8]

public class BinaryTreePostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    My first iterative approach is by reversing the preorder (right child first) traversal result list
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode current = root;

        if (current == null) {
            return result;
        }

        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.pop();
            result.add(current.val);

            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        Collections.reverse(result);
        return result;
    }

//    TODO: not yet implemented
    private class IterativePostOrder {
        public List<Integer> postorderTraversal(TreeNode root) {
            return new ArrayList<>();
        }
    }

    private class IterativePostOrderByReverseOfRightFirstPreOrder {
        public List<Integer> postorderTraversal(TreeNode root) {

            List<Integer> result = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();

            TreeNode current = root;

            if (current == null) {
                return result;
            }

            stack.push(current);
            while (!stack.isEmpty()) {
                current = stack.pop();
                result.add(current.val);

                if (current.left != null) {
                    stack.push(current.left);
                }
                if (current.right != null) {
                    stack.push(current.right);
                }
            }

            Collections.reverse(result);
            return result;
        }
    }

    private class RecursionApproachPostOrder {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) {
                return result;
            }

            result.addAll(postorderTraversal(root.left));
            result.addAll(postorderTraversal(root.right));
            result.add(root.val);

            return result;
        }
    }

}
