package online.leetcode;

/**
 * Created by Hey on 27/3/16
 */

/*

https://leetcode.com/problems/jump-game/

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Subscribe to see which companies asked this question

*/

public class JumpGame {
//    3ms
    public boolean canJump(int[] nums) {
        final int n = nums.length;
        if (n <= 1) {
            return true;
        }

        int cur = 0;
        int max = cur+nums[cur];
        while (cur < max) {
            if (max>=n-1){
                return true;
            }
            ++cur;
            max = Math.max(max, cur+nums[cur]);
        }
        return false;
    }

    private class BorrowedFromJumpGameII {
        //    4ms
        public boolean canJump(int[] nums) {
            final int n = nums.length;
            if (n <= 0) {
                return true;
            }
            int cur = 0;
            while (cur < n - 1) {
                int max = cur;
                int shouldMoveTo = cur;
                for (int i = cur + 1; (i < n) && (i <= cur + nums[cur]); ++i) {
                    if (i >= n - 1) {
                        return true;
                    }
                    final int reachable = i + nums[i];
                    if (reachable >= max) {
                        shouldMoveTo = i;
                        max = reachable;
                    }
                }
                if (shouldMoveTo == cur) {
                    return false;
                }
                cur = shouldMoveTo;
            }
            return true;
        }
    }

    private class FailedAttempt {
        public boolean canJump(int[] nums) {
            final int length = nums.length;
            if (length <= 1) {
                return true;
            }
            for (int i = length - 2; i >= 0; --i) {
                if (nums[i] >= (length - 1 - i)) {
                    return true;
                }
            }
            return false;
        }
    }
}
