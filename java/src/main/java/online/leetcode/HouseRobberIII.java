package online.leetcode;

/*

https://leetcode.com/problems/house-robber-iii/

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.

*/

import online.leetcode.util.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class HouseRobberIII {
    static class Solution {
        private class Decision {
            final int maxWhenTake;
            final int maxWhenNotTake;

            Decision(int maxWhenTake, int maxWhenNotTake) {
                this.maxWhenTake = maxWhenTake;
                this.maxWhenNotTake = maxWhenNotTake;
            }
        }

        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                Decision d = buildDecision(root);
                return Math.max(d.maxWhenTake, d.maxWhenNotTake);
            }
        }

        private Decision buildDecision(TreeNode root) {
            if (root == null) {
                return new Decision(0, 0);
            } else {
                Decision left = buildDecision(root.left);
                Decision right = buildDecision(root.right);

                int maxWhenTake = root.val + left.maxWhenNotTake + right.maxWhenNotTake;
                int maxWhenNotTake = Math.max(left.maxWhenTake, left.maxWhenNotTake) + Math.max(right.maxWhenTake, right.maxWhenNotTake);

                return new Decision(maxWhenTake, maxWhenNotTake);
            }
        }
    }
}
