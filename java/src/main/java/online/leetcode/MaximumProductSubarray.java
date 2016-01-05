package online.leetcode;

/**
 * Created by Hey on 13/12/15
 */

/*

https://leetcode.com/problems/maximum-product-subarray/

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

Subscribe to see which companies asked this question

*/

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        final int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        long beforeFirstMinus = 1;
        long firstMinusMagnitude = 1;
        long afterLastMinus = 1;
        long lastMinusMagnitude = 1;
        long curSubArray = 0;
        long numberOfMinus = 0;
        long best = nums[0];
        for (int num : nums) {
            if (num == 0) {
                best = getBest(beforeFirstMinus, firstMinusMagnitude, afterLastMinus, lastMinusMagnitude, curSubArray, numberOfMinus, best);
                beforeFirstMinus = 1;
                firstMinusMagnitude = 1;
                afterLastMinus = 1;
                lastMinusMagnitude = 1;
                numberOfMinus = 0;
                curSubArray = 0;
            } else if (num < 0) {
                if (numberOfMinus == 0) {
                    firstMinusMagnitude = -num;
                }
                if (numberOfMinus > 0) {
                    curSubArray = (curSubArray == 0) ? -num : (curSubArray * -num);
                }
                lastMinusMagnitude = -num;
                afterLastMinus = 1;
                ++numberOfMinus;
            } else {
                if (numberOfMinus == 0) {
                    beforeFirstMinus *= num;
                } else {
                    afterLastMinus *= num;
                }
                curSubArray = (curSubArray == 0) ? num : (curSubArray * num);
            }
        }

        best = getBest(beforeFirstMinus, firstMinusMagnitude, afterLastMinus, lastMinusMagnitude, curSubArray, numberOfMinus, best);
        return (int) best;
    }

    private long getBest(long beforeFirstMinus, long firstMinusMagnitude, long afterLastMinus, long lastMinusMagnitude, long curSubArray, long numberOfMinus, long best) {
        curSubArray *= firstMinusMagnitude;
        if (numberOfMinus % 2 != 0) {
            if ((beforeFirstMinus * firstMinusMagnitude) > (afterLastMinus * lastMinusMagnitude)) {
                curSubArray /= afterLastMinus;
                curSubArray /= lastMinusMagnitude;
            } else {
                curSubArray /= beforeFirstMinus;
                curSubArray /= firstMinusMagnitude;
            }
        }
        best = Math.max(curSubArray, best);
        return best;
    }

    //    SPOILER ALERT
//    Solution:
//    https://leetcode.com/problems/maximum-product-subarray/solution/
//    SPOILER ALERT
    private class DPApproachAccordingToSolution {
        public int maxProduct(int[] nums) {
            final int length = nums.length;
            if (length == 0) {
                return 0;
            }
            int f[] = new int[length + 1];
            int g[] = new int[length + 1];

            f[0] = nums[0];
            g[0] = nums[0];
            int best = nums[0];
            for (int i = 1; i < length; ++i) {
                f[i] = Math.max(Math.max(f[i - 1] * nums[i], nums[i]), g[i - 1] * nums[i]);
                g[i] = Math.min(Math.min(f[i - 1] * nums[i], nums[i]), g[i - 1] * nums[i]);
                best = Math.max(f[i], best);
            }

            return best;
        }
    }


}
