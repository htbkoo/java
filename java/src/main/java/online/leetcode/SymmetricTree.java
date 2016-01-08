package online.leetcode;

/**
 * Created by Hey on 7/1/16
 */

/*

https://leetcode.com/problems/symmetric-tree/

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:

    1
   / \
  2   2
   \   \
   3    3

Note:
Bonus points if you could solve it both recursively and iteratively.

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Subscribe to see which companies asked this question

*/

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

public class SymmetricTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //    First Attempt is Recursive Approach
    public boolean isSymmetric(TreeNode root) {
        return root == null || (areTwoTreesSymmetric(root.left, root.right));
    }

    private boolean areTwoTreesSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return (root2 == null);
        }
        return root2 != null
                && root1.val == root2.val
                && (areTwoTreesSymmetric(root1.left, root2.right))
                && (areTwoTreesSymmetric(root1.right, root2.left));
    }

    public class IterativeApproach {
        //        Test case: [1,2,2,3,4,4,3,5,6,7,8,8,7,6,5]
        //        Test case: [1,2]
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            Deque<TreeNode> lQueue = new ArrayDeque<>();
            Deque<TreeNode> rQueue = new ArrayDeque<>();

            if (root.left != null) {
                lQueue.add(root.left);
            }
            if (root.right != null) {
                rQueue.add(root.right);
            }
            while (!lQueue.isEmpty() && !rQueue.isEmpty()) {
                TreeNode left = lQueue.poll();
                TreeNode right = rQueue.poll();
                if (left.val!=right.val){
                    return false;
                }

                if (left.left!=null){
                    if (right.right!=null){
                        lQueue.add(left.left);
                        rQueue.add(right.right);
                    }else {
                        return false;
                    }
                }else{
                    if (right.right!=null){
                        return false;
                    }
                }

                if (left.right!=null){
                    if (right.left!=null){
                        lQueue.add(left.right);
                        rQueue.add(right.left);
                    }else {
                        return false;
                    }
                }else{
                    if (right.left!=null){
                        return false;
                    }
                }
            }

            return lQueue.isEmpty()&&rQueue.isEmpty();
        }
    }

    public class RecursiveApproach {
        //        Test case: [1,2,2,3,4,4,3,5,6,7,8,8,7,6,5]
        public boolean isSymmetric(TreeNode root) {
            return root == null || (areTwoTreesSymmetric(root.left, root.right));
        }

        private boolean areTwoTreesSymmetric(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return (root2 == null);
            }
            /*
            if (root2 == null) {
                return false;
            }
            if (root1.val != root2.val) {
                return false;
            }
            return (areTwoTreesSymmetric(root1.left, root2.right)) && (areTwoTreesSymmetric(root1.right, root2.left));
            */
            return root2 != null && root1.val == root2.val && (areTwoTreesSymmetric(root1.left, root2.right)) && (areTwoTreesSymmetric(root1.right, root2.left));
        }
    }
}
