package online.leetcode;

/**
 * Created by Hey on 5/12/15
 */

/*

https://leetcode.com/problems/house-robber/

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.

Subscribe to see which companies asked this question

*/

public class HouseRobber {
//    0ms after redundant max check removal
    public int rob(int[] nums) {
        final int length = nums.length;
        int[] f = new int[length + 2];

        for (int i = length - 1; i >= 0; --i) {
            f[i] = Math.max(f[i + 1], f[i + 2] + nums[i]);
        }
        return f[0];
    }

//    First Iterative Approach attempt, with last redundant max check causing running time to become 1ms
    private class IterativeApproach {
        public int rob(int[] nums) {
            final int length = nums.length;
            int[] f = new int[length + 2];

            for (int i = length - 1; i >= 0; --i) {
                f[i] = Math.max(f[i + 1], f[i + 2] + nums[i]);
            }
            return Math.max(f[0], f[1]);
        }
    }

    private class RecursiveApproach {
        private int[] f;
        private boolean[] calculated;

        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            f = new int[nums.length + 2];
            calculated = new boolean[nums.length + 2];

            return calculate(nums, 0);
        }

        private int calculate(int[] nums, int index) {
            if (index >= nums.length) {
                return 0;
            }
            if (!calculated[index]) {
                f[index] = Math.max(calculate(nums, index + 1), calculate(nums, index + 2) + nums[index]);
                calculated[index] = true;
            }
            return f[index];
        }
    }
}
