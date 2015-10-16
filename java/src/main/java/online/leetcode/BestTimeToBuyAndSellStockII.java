package online.leetcode;

/**
 * Created by Hey on 13/10/15
 */

/*

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int totalVal = 0;
        int maxVal = 0;
        int curMin = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            int earn = Math.max(0, prices[i] - curMin);
            if (earn > maxVal) {
                maxVal = earn;
            }
            if (prices[i] < prices[i - 1]) {
                totalVal += maxVal;
                maxVal = 0;
                curMin = prices[i];
            }

        }
        return totalVal + maxVal;
    }
}
