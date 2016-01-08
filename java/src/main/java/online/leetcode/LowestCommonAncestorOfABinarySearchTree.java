package online.leetcode;

import online.leetcode.util.TreeNode;

/**
 * Created by Hey on 11/12/15
 */

/*

https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5

For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Subscribe to see which companies asked this question

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root == null) || (p == null) || (q == null)) {
            return root;
        }

        final int currentVal = root.val;

        if ((currentVal == p.val) || (p.val == q.val)) {
            return p;
        }

        if (currentVal == q.val) {
            return q;
        }

        final int largerVal = Math.max(p.val, q.val);
        final int smallerVal = Math.min(p.val, q.val);

        if ((currentVal < largerVal) && (currentVal > smallerVal)) {
            return root;
        } else if (currentVal < smallerVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (currentVal > largerVal) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }
}
