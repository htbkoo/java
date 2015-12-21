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

public class MaximumSubarray {
    public int maxProduct(int[] nums) {
        final int length = nums.length;
        int curSubArray = nums[0];
        int best = nums[0];
        for (int i = 1; i < length; ++i) {
            if (curSubArray > 0) {
                curSubArray += nums[i];
            } else {
                curSubArray = nums[i];
            }
            best = Math.max(curSubArray, best);
        }
        return best;
    }
}
