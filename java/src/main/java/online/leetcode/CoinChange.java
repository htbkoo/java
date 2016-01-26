package online.leetcode;

import java.util.ArrayList;
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
