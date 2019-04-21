/*

https://leetcode.com/problems/minimum-cost-for-tickets/

In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:

    a 1-day pass is sold for costs[0] dollars;
    a 7-day pass is sold for costs[1] dollars;
    a 30-day pass is sold for costs[2] dollars.

The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.



Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation:
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.

Example 2:

Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation:
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total you spent $17 and covered all the days of your travel.



Note:

    1 <= days.length <= 365
    1 <= days[i] <= 365
    days is in strictly increasing order.
    costs.length == 3
    1 <= costs[i] <= 1000

*/

package online.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumCostForTickets {
    class Solution {

        private static final int ONE_DAY = 1;
        private static final int SEVEN_DAY = 7;
        private static final int THIRTY_DAY = 30;

        private class Pass {
            final int numDays;
            final int cost;

            private Pass(int numDays, int cost) {
                this.numDays = numDays;
                this.cost = cost;
            }
        }

        public int mincostTickets(int[] days, int[] costs) {
            List<Pass> passes = passesFromArray(costs);
            int numDays = days[days.length - 1];
            final int[] minCosts = new int[numDays + 1];

            Set<Integer> daysInSet = Arrays.stream(days).boxed().collect(Collectors.toSet());

            IntStream.range(1, numDays + 1)
                    .forEach(d -> {
                                if (daysInSet.contains(d)) {
                                    int newMinCost = passes.stream()
                                            .mapToInt(pass -> minCosts[Math.max(0, d - pass.numDays)] + pass.cost)
                                            .min()
                                            .orElseThrow(() -> new RuntimeException("Defect, passes is empty"));
                                    minCosts[d] = newMinCost;
                                } else {
                                    minCosts[d] = minCosts[d - 1];
                                }
                            }
                    );

            return minCosts[numDays];
        }

        private List<Pass> passesFromArray(int[] costs) {
            List<Pass> passes = new ArrayList<>();
            passes.add(new Pass(ONE_DAY, costs[0]));
            passes.add(new Pass(SEVEN_DAY, costs[1]));
            passes.add(new Pass(THIRTY_DAY, costs[2]));
            return passes;
        }
    }
}
