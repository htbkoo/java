package online.leetcode;

/**
 * Created by Hey on 30/12/15
 */

/*

https://leetcode.com/problems/validate-binary-search-tree/

 Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

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

public class ValidateBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        //        return isValidBSSubTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root == null || isValidBSSubTree(root.left, ((long) Integer.MIN_VALUE - 1), root.val) && isValidBSSubTree(root.right, root.val, ((long) Integer.MAX_VALUE) + 1);
    }

    private boolean isValidBSSubTree(TreeNode treeNode, long min, long max) {
        if (treeNode == null) {
            return true;
        }

        if (!((treeNode.val < max) && (treeNode.val > min))) {
            return false;
        }
/*
        if (treeNode.left != null) {
            if (!(treeNode.left.val < treeNode.val)) {
                return false;
            }
        }

        if (treeNode.right != null) {
            if (!(treeNode.right.val > treeNode.val)) {
                return false;
            }
        }
*/
        return isValidBSSubTree(treeNode.left, min, treeNode.val) && isValidBSSubTree(treeNode.right, treeNode.val, max);
    }
}
