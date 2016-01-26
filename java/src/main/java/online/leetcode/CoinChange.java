package online.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Hey on 26/1/16
 */

/*

https://leetcode.com/problems/coin-change/

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class CoinChange {
    //        Only start the core part after LCM, replace previous with ((int)Amount/largest)*largest

    private class SlightImprovementWithoutSortingAndSkipping {
        //        28ms, without sort and skip
        //        -rolling array
        public int coinChange(int[] coins, int amount) {
            int count = 0;
            if (amount == 0) {
                return count;
            }

            int[] minCoinNeeded = new int[amount + 1];
            minCoinNeeded[0] = 0;
            for (int i = 1; i <= amount; ++i) {
                minCoinNeeded[i] = -1;
                for (int c : coins) {
                    final int prev = i - c;
                    if (prev >= 0) {
                        if (minCoinNeeded[prev] != -1) {
                            if (minCoinNeeded[i] != -1) {
                                minCoinNeeded[i] = Math.min(minCoinNeeded[prev] + 1, minCoinNeeded[i]);
                            } else {
                                minCoinNeeded[i] = minCoinNeeded[prev] + 1;
                            }
                        }
                    }
                }
            }

            return minCoinNeeded[amount];
        }
    }

    private class PrematureOptimizationWithBottomUpApproach {
        //        29ms
        //        +sort and skip
        //        -rolling array
        public int coinChange(int[] coins, int amount) {
            int count = 0;
            if (amount == 0) {
                return count;
            }

            //        Optional?
            Arrays.sort(coins);

            int[] minCoinNeeded = new int[amount + 1];
            minCoinNeeded[0] = 0;
            for (int i = 1; i <= amount; ++i) {
                minCoinNeeded[i] = -1;
                for (int c : coins) {
                    final int prev = i - c;
                    if (prev >= 0) {
                        if (minCoinNeeded[prev] != -1) {
                            if (minCoinNeeded[i] != -1) {
                                minCoinNeeded[i] = Math.min(minCoinNeeded[prev] + 1, minCoinNeeded[i]);
                            } else {
                                minCoinNeeded[i] = minCoinNeeded[prev] + 1;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }

            return minCoinNeeded[amount];
        }
    }

    private class temp {
        //    bottom-up approach
        //    much faster than top-down, though still slow, 50 ms
        public int coinChange(int[] coins, int amount) {
            int count = 0;
            if (amount == 0) {
                return count;
            }

            int arraySize = 0;

            for (int c : coins) {
                arraySize = Math.max(c, arraySize);
            }

            int[] minCoinNeeded = new int[arraySize + 1];
            minCoinNeeded[0] = 0;
            for (int i = 1; i <= amount; ++i) {
                final int curArrayPointer = i % (arraySize + 1);
                minCoinNeeded[curArrayPointer] = -1;
                for (int c : coins) {
                    final int prev = i - c;
                    if (prev >= 0) {
                        final int prevArrayPointer = prev % (arraySize + 1);
                        if (minCoinNeeded[prevArrayPointer] != -1) {
                            if (minCoinNeeded[curArrayPointer] != -1) {
                                minCoinNeeded[curArrayPointer] = Math.min(minCoinNeeded[prevArrayPointer] + 1, minCoinNeeded[curArrayPointer]);
                            } else {
                                minCoinNeeded[curArrayPointer] = minCoinNeeded[prevArrayPointer] + 1;
                            }
                        }
                    }
                }
            }

            return minCoinNeeded[amount % (arraySize + 1)];
        }
    }

    private class TopDownBFSWithMemoizationApproach {
        //    223ms, extremely slow
        //    BFS with memoization
        public int coinChange(int[] coins, int amount) {
            int count = 0;
            if (amount == 0) {
                return count;
            }

            Set<Integer> set = new HashSet<>();
            List<Integer> thisGen;
            List<Integer> nextGen = new ArrayList<>();
            set.add(amount);
            nextGen.add(amount);

            while (!nextGen.isEmpty()) {
                ++count;
                thisGen = nextGen;
                nextGen = new ArrayList<>();
                for (int i : thisGen) {
                    for (int c : coins) {
                        final int remainingAmount = i - c;
                        if (remainingAmount == 0) {
                            return count;
                        } else if (remainingAmount > 0) {
                            if (!set.contains(remainingAmount)) {
                                set.add(remainingAmount);
                                nextGen.add(remainingAmount);
                            }
                        }

                    }
                }
            }
            return -1;
        }
    }
}
