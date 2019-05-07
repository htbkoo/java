package online.leetcode;

/*

https://leetcode.com/problems/distribute-coins-in-binary-tree/

Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.

In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)

Return the number of moves required to make every node have exactly one coin.



Example 1:

Input: [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.

Example 2:

Input: [0,3,0]
Output: 3
Explanation: From the left child of the root, we move two coins to the root [taking two moves].  Then, we move one coin from the root of the tree to the right child.

Example 3:

Input: [1,0,2]
Output: 2

Example 4:

Input: [1,0,0,null,3]
Output: 4



Note:

    1<= N <= 100
    0 <= node.val <= N

*/

import online.leetcode.util.TreeNode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DistributeCoinsInBinaryTree {
    static class Solution {
        private TreeMap<Integer, Integer> newDistributionMap() {
            return new TreeMap<>((a, b) -> Integer.compare(b, a));
        }

        private class Distribution {
            final TreeMap<Integer, Integer> distribution = new TreeMap<>();
        }

        private class Movement {
            final TreeMap<Integer, Integer> lack;
            final TreeMap<Integer, Integer> surplus;
            final int numMoves;

            Movement(int numMoves) {
                this.numMoves = numMoves;
                this.lack = newDistributionMap();
                this.surplus = newDistributionMap();
            }

            Movement(TreeMap<Integer, Integer> lack, TreeMap<Integer, Integer> surplus, int numMoves) {
                this.lack = lack;
                this.surplus = surplus;
                this.numMoves = numMoves;
            }
        }

        public int distributeCoins(TreeNode root) {
            if (root == null) {
                return 0; // assume zero moves needed for empty tree
            } else {
                return countDistribute(root).numMoves;
            }
        }

        private Movement countDistribute(TreeNode root) {
            if (root == null) {
                return new Movement(0); // assume zero moves needed for empty tree
            } else {
                Movement left = countDistribute(root.left);
                Movement right = countDistribute(root.right);

                TreeMap<Integer, Integer> lack = newDistributionMap();
                TreeMap<Integer, Integer> surplus = newDistributionMap();

                if (root.val == 0) {
                    int distance = 0, count = 1;
                    lack.put(distance, count);
                } else if (root.val > 1) {
                    surplus.put(0, root.val - 1);
                }

                putAllPlusOneDistance(lack, left.lack);
                putAllPlusOneDistance(lack, right.lack);

                putAllPlusOneDistance(surplus, left.surplus);
                putAllPlusOneDistance(surplus, right.surplus);

                return resolveDistribution(lack, surplus, left.numMoves + right.numMoves);
            }
        }

        private void putAllPlusOneDistance(Map<Integer, Integer> base, Map<Integer, Integer> additional) {
            for (Map.Entry<Integer, Integer> entry : additional.entrySet()) {
                int distance = entry.getKey() + 1;
                int count = entry.getValue();
                base.put(distance, base.getOrDefault(distance, 0) + count);
            }
        }

        private Movement resolveDistribution(TreeMap<Integer, Integer> lack, TreeMap<Integer, Integer> surplus, int numMoves) {
            if (lack.isEmpty() && surplus.isEmpty()) {
                return new Movement(numMoves);
            } else if (lack.isEmpty() || surplus.isEmpty()) {
                return new Movement(lack, surplus, numMoves);
            } else {
                Iterator<Map.Entry<Integer, Integer>> itrLack = lack.entrySet().iterator(), itrSurplus = surplus.entrySet().iterator();
                Map.Entry<Integer, Integer> lackPair = itrLack.next();
                Map.Entry<Integer, Integer> surplusPair = itrSurplus.next();
                do {
                    numMoves += 1;
                } while (itrLack.hasNext() && itrSurplus.hasNext());
                int lackCount = 0, surplusCount = 0;
                for (int count : lack.values()) {
                    lackCount += count;
                }
                for (int count : surplus.values()) {
                    surplusCount += count;
                }
            }
        }
    }
}
