package online.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
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

    //    BFS with memoization
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        if (amount == 0) {
            return count;
        }

        Set<Integer> set = new HashSet<>();
        Deque<Integer> queue= new ArrayDeque<>();
        set.add(amount);
        queue.add(amount);

        while (!queue.isEmpty()) {
            ++count;
            final int i = queue.poll();
            for (final Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); ) {
//                int i = iterator.next();
                iterator.remove();
//                set.remove(i);
                for (int c : coins) {
                    final int remainingAmount = i - c;
                    if (remainingAmount == 0) {
                        return count;
                    } else if (remainingAmount > 0) {
                        set.add(remainingAmount);
                    }
                }
            }

//            Core part, throw ConcurrentModificationException if iterator is not used
//            for (Integer i : set) {
//                set.remove(i);
//                for (int c : coins) {
//                    final int remainingAmount = i - c;
//                    if (remainingAmount == 0){
//                        return count;
//                    }else if (remainingAmount>0){
//                        set.add(remainingAmount);
//                    }
//                }
//            }
        }
        return -1;
    }
}
