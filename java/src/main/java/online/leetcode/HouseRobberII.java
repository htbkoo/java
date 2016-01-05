package online.leetcode;

/**
 * Created by Hey on 4/1/16
 */

/*

https://leetcode.com/problems/house-robber-ii/

Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class HouseRobberII {
    public int rob(int[] nums) {
        final int length = nums.length;

        if (length == 0) {
            return 0;
        }

        if (length == 1) {
            return nums[0];
        }

        int[] f1 = new int[length + 2];
        int[] f2 = new int[length + 2];

        for (int i = length - 1; i >= 1; --i) {
            f1[i] = Math.max(f1[i + 1], f1[i + 2] + nums[i]);
        }
        for (int i = length - 2; i >= 0; --i) {
            f2[i] = Math.max(f2[i + 1], f2[i + 2] + nums[i]);
        }
        return Math.max(f1[1], f2[0]);
    }
}
