package online.leetcode;

import online.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*

https://leetcode.com/problems/find-mode-in-binary-search-tree/

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than or equal to the node's key.
    The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
    Both the left and right subtrees must also be binary search trees.



For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2



return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

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
public class FindModeInBinarySearchTree {
    static class Solution {
        public int[] findMode(TreeNode root) {
            if (root == null) {
                return new int[0];
            } else {
                Map<Integer, Integer> freq = count(root);
                PriorityQueue<Map.Entry<Integer, Integer>> countsHeap = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
                countsHeap.addAll(freq.entrySet());

                List<Integer> answer = new ArrayList<>();
                if (!countsHeap.isEmpty()) {
                    int maxCount = countsHeap.peek().getValue();
                    while (!countsHeap.isEmpty() && countsHeap.peek().getValue() == maxCount) {
                        answer.add(countsHeap.poll().getKey());
                    }
                }
                return answer.stream().mapToInt(i -> i).toArray();
            }
        }

        private Map<Integer, Integer> count(TreeNode root) {
            if (root == null) {
                return new HashMap<>();
            } else {
                Map<Integer, Integer> freq = new HashMap<>();
                freq.put(root.val, freq.getOrDefault(root.val, 0) + 1);
                count(root.left).forEach((val, count) -> freq.put(val, freq.getOrDefault(val, 0) + count));
                count(root.right).forEach((val, count) -> freq.put(val, freq.getOrDefault(val, 0) + count));
                return freq;
            }
        }
    }
}
