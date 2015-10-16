package online.leetcode;

/**
 * Created by Hey on 13/10/15
 */

/*

https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

*/

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int maxVal = 0;
        int curMin = prices[0];
        for (int price : prices) {
            int earn = Math.max(0, price - curMin);
            if (earn > maxVal) {
                maxVal = earn;
            }
            if (price < curMin) {
                curMin = price;
            }

        }
        return maxVal;
    }
}
