package online.leetcode;

import online.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        final List<StringBuilder> stringBuilderList = findPaths(root);
        final ArrayList<String> paths = new ArrayList<>();
        //noinspection ConstantConditions // Impossible to be null
        for (StringBuilder sb : stringBuilderList) {
            paths.add(sb.toString());
        }
        return paths;
    }

    private List<StringBuilder> findPaths(TreeNode node) {
        if ((node.left == null) && (node.right == null)) {
            return Collections.singletonList(new StringBuilder(String.valueOf(node.val)));
//            return Collections.singletonList(String.valueOf(node.val));
        }

        List<StringBuilder> paths = new ArrayList<>();
        if (node.left != null) {
            final StringBuilder leftPathHead = new StringBuilder(String.valueOf(node.left.val));
            final List<StringBuilder> leftPaths = findPaths(node.left);
            for (StringBuilder sb:leftPaths){
                paths.add(leftPathHead.append("->").append(sb));
            }
        }
        if (node.right != null) {
            final StringBuilder rightPathHead = new StringBuilder(String.valueOf(node.right.val));
            final List<StringBuilder> rightPaths = findPaths(node.right);
            for (StringBuilder sb:rightPaths){
                paths.add(rightPathHead.append("->").append(sb));
            }
        }

        return paths;
    }
}
