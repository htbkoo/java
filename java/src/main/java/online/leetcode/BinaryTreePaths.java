package online.leetcode;

import online.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hey on 23/1/16
 */

/*

https://leetcode.com/problems/binary-tree-paths/

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:

["1->2->5", "1->3"]

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

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

public class BinaryTreePaths {
//    4ms
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return findPaths(root);
    }

    private List<String> findPaths(TreeNode node) {
        final String pathHead = String.valueOf(node.val);
        final TreeNode left = node.left;
        final TreeNode right = node.right;
        if ((left == null) && (right == null)) {
            return Collections.singletonList(pathHead);
        }
        final List<String> paths = new ArrayList<>();
        addPathsToList(pathHead, left, paths);
        addPathsToList(pathHead, right, paths);

        return paths;
    }

    private void addPathsToList(String pathHead, TreeNode node, List<String> paths) {
        if (node != null) {
            final List<String> leftPaths = findPaths(node);
            for (String path : leftPaths) {
                paths.add(pathHead + "->" + path);
            }
        }
    }

    private class SlowApproachUsingStringBuilder {
//        7ms
        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            final List<StringBuilder> stringBuilderList = findPaths(root);
            return stringBuilderList.stream().map(StringBuilder::toString).collect(Collectors.toCollection(ArrayList::new));
        }

        private List<StringBuilder> findPaths(TreeNode node) {
            if ((node.left == null) && (node.right == null)) {
                final StringBuilder nodeSB = new StringBuilder(String.valueOf(node.val));
                return Collections.singletonList(nodeSB);
            }

            List<StringBuilder> paths = new ArrayList<>();
            if (node.left != null) {
                final List<StringBuilder> leftPaths = findPaths(node.left);
                for (StringBuilder sb : leftPaths) {
                    final StringBuilder leftPathHead = new StringBuilder(String.valueOf(node.val));
                    paths.add(leftPathHead.append("->").append(sb));
                }
            }
            if (node.right != null) {
                final List<StringBuilder> rightPaths = findPaths(node.right);
                for (StringBuilder sb : rightPaths) {
                    final StringBuilder rightPathHead = new StringBuilder(String.valueOf(node.val));
                    paths.add(rightPathHead.append("->").append(sb));
                }
            }

            return paths;
        }
    }
}
