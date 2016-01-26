package online.leetcode;

/**
 * Created by Hey on 26/1/16
 */

/*

https://leetcode.com/problems/perfect-squares/

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class PerfectSquares {
    //    Quite slow, 118ms
    //    used same core part of CoinChange
    public int numSquares(int n) {
        final int ARRAY_SIZE = (int) Math.sqrt(n);
        final int[] squares = new int[ARRAY_SIZE];
        for (int i = 1; i <= ARRAY_SIZE; ++i) {
            squares[i - 1] = i * i;
        }
        return coinChange(squares, n);
    }

    private int coinChange(int[] coins, int amount) {
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
