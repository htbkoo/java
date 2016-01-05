package online.leetcode;

/**
 * Created by Hey on 13/12/15
 */

/*

https://leetcode.com/problems/maximum-subarray/

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Subscribe to see which companies asked this question

*/

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
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
