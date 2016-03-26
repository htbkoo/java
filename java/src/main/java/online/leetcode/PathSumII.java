package online.leetcode;

import online.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Hey on 25/3/16
 */

/*

https://leetcode.com/problems/path-sum-ii/

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

return

[
   [5,4,11,2],
   [5,8,4,5]
]

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

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return Collections.emptyList();
        }

        return pathSum(root, sum, new ArrayList<>());
    }

    private List<List<Integer>> pathSum(TreeNode root, int sum, List<Integer> currentPath) {
        ArrayList<List<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> newPath = new ArrayList<>(currentPath);
        newPath.add(root.val);

        if ((root.left == null) && (root.right == null)) {
            if (sum == root.val){
                paths.add(newPath);
            }
        }

        if (root.left != null) {
            paths.addAll(pathSum(root.left, sum - root.val, newPath));
        }

        if (root.right != null) {
            paths.addAll(pathSum(root.right, sum - root.val, newPath));
        }

        return paths;
    }
}
