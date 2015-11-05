package online.leetcode;

/**
 * Created by Hey on 13/10/15
 */

/*

https://leetcode.com/problems/jump-game-ii/

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Subscribe to see which companies asked this question

*/

public class JumpGameII {
    public int jump(int[] nums) {
        final int n = nums.length;
        if (n <= 0) {
            return 0;
        }
        int cur = 0;
        int count = 0;
        while (cur < n - 1) {
            ++count;
            int max = cur;
            int shouldMoveTo = cur;
            for (int i = cur + 1; (i < n) && (i <= cur + nums[cur]); ++i) {
                if (i >= n - 1) {
                    return count;
                }
                final int reachable = i + nums[i];
                if (reachable >= max) {
                    shouldMoveTo = i;
                    max = reachable;
                }
            }
            cur = shouldMoveTo;
        }

        return count;
    }

    private class OnSquare {
        public int jump(int[] nums) {
            final int n = nums.length;
            if (n <= 0) {
                return 0;
            }

            int[] f = new int[n];
            f[n - 1] = 0;
            for (int i = n - 2; i >= 0; --i) {
                int temp = n + 1;
                for (int j = 1; (j <= nums[i] && ((i + j) < n)); ++j) {
                    temp = Math.min(f[i + j] + 1, temp);
                }
                f[i] = temp;
            }

            return f[0];
        }
    }
}
