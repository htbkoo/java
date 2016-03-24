package online.leetcode;

import online.leetcode.util.TreeNode;

/**
 * Created by Hey on 25/3/16
 */
/*

https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

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

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return createBstFromSortedArray(nums, 0, nums.length - 1);
    }

    private TreeNode createBstFromSortedArray(int[] nums, int first, int last) {
        if (last < first) {
            return null;
        }
        int middle = (first + last) / 2;
        TreeNode treeNode = new TreeNode(nums[middle]);
        if (first != last) {
            treeNode.left = createBstFromSortedArray(nums, first, middle - 1);
            treeNode.right = createBstFromSortedArray(nums, middle + 1, last);
        }
        return treeNode;
    }
}
