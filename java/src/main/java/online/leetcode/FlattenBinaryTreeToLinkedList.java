package online.leetcode;

/**
 * Created by Hey on 1/1/16
 */

/*

https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

 Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

click to show hints.

Hints:

If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

Subscribe to see which companies asked this question

*/

import java.util.ArrayList;
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

public class FlattenBinaryTreeToLinkedList {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        List<TreeNode> preorder = preorderTraversal(root);
        if (!preorder.isEmpty()) {
            preorder.remove(0);
            for (TreeNode node : preorder) {
                root.left = null;
                root.right = node;
                root = root.right;
            }
        }
    }

    private List<TreeNode> preorderTraversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.add(root);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));

        return result;
    }

    public class FailedAttempt {

        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode leftTail;
            TreeNode rightHead = root.right;
            flatten(root.right);
//        if (root.right != null) {
//            flattenAndGetTail(root.right);
//        }
            if (root.left != null) {
                leftTail = flattenAndGetTail(root);
                root.right = root.left;
                leftTail.right = rightHead;
            }
        }

        private TreeNode flattenAndGetTail(TreeNode treeNode) {
            TreeNode leftTail;
            TreeNode rightHead = treeNode.right;
            TreeNode tail = treeNode;
            if (treeNode.right != null) {
                tail = flattenAndGetTail(treeNode.right);
            }
            if (treeNode.left != null) {
                leftTail = flattenAndGetTail(treeNode.left);
                treeNode.right = treeNode.left;
                if (rightHead != null) {
                    leftTail.right = rightHead;
                } else {
                    tail = leftTail;
                }
            }
            return tail;
        }
    }
}
