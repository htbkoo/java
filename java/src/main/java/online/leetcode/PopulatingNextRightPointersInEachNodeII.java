package online.leetcode;

/**
 * Created by Hey on 25/3/16
 */
/*

https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

    You may only use constant extra space.

For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

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

public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        root.next = null;

        connectChildren(root);
    }

    private void connectChildren(TreeLinkNode node) {
        TreeLinkNode nodeNext = node.next;
        if ((node.left != null)) {
            if (node.right != null) {
                node.left.next = node.right;
                connectToChildrenOfNodeNext(node.right, nodeNext);

//                The order IS important, must first do right child
                connectChildren(node.right);
                connectChildren(node.left);
            } else {
                connectToChildrenOfNodeNext(node.left, nodeNext);
                connectChildren(node.left);
            }
        } else {
            if (node.right != null) {
                connectToChildrenOfNodeNext(node.right, nodeNext);
                connectChildren(node.right);
            }
        }
    }


    private void connectToChildrenOfNodeNext(TreeLinkNode node, TreeLinkNode auntNode) {
        while (auntNode != null) {
            if (auntNode.left != null) {
                node.next = auntNode.left;
                return;
            } else if (auntNode.right != null) {
                node.next = auntNode.right;
                return;
            }
            auntNode = auntNode.next;
        }
        node.next = null;
    }

}

/*
// Failed attempt by missing the far-separated nodes in the following case
 Input: {1,2,3,4,5,#,6,7,#,#,#,#,8}
Output: {1,#,2,3,#,4,5,6,#,7,#}
Expected: {1,#,2,3,#,4,5,6,#,7,8,#}

    private void connectToChildrenOfNodeNext(TreeLinkNode node, TreeLinkNode auntNode) {
        if (auntNode == null) {
            node.next = null;
        } else {
            if (auntNode.left != null) {
                node.next = auntNode.left;
            } else {
                if (auntNode.right != null) {
                    node.next = auntNode.right;
                }else{
                    node.next = null;
                }
            }
        }
    }*/
