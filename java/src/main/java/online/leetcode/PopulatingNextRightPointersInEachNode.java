package online.leetcode;

/**
 * Created by Hey on 25/3/16
 */
/*

https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

 Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

Subscribe to see which companies asked this question

*/

import online.leetcode.util.TreeLinkNode;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 * int val;
 * TreeLinkNode left, right, next;
 * TreeLinkNode(int x) { val = x; }
 * }
 */

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        root.next = null;

        connectChildren(root);
    }

    private void connectChildren(TreeLinkNode node) {
//        perfect binary tree
        if (node.left != null) {
//        if ((node.left!=null)&&(node.right!=null)){
            node.left.next = node.right;
            if (node.next == null) {
                node.right.next = null;
            } else {
                node.right.next = node.next.left;
            }
            connectChildren(node.left);
            connectChildren(node.right);
        }
    }
}

