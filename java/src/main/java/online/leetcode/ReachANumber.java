package online.leetcode;

/*

https://leetcode.com/problems/reach-a-number/

You are standing at position 0 on an infinite number line. There is a goal at position target.

On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

Return the minimum number of steps required to reach the destination.

Example 1:

Input: target = 3
Output: 2
Explanation:
On the first move we step from 0 to 1.
On the second step we step from 1 to 3.

Example 2:

Input: target = 2
Output: 3
Explanation:
On the first move we step from 0 to 1.
On the second move we step  from 1 to -1.
On the third move we step from -1 to 2.

Note:
target will be a non-zero integer in the range [-10^9, 10^9].

*/

public class ReachANumber {
    static class Solution {
        public int reachNumber(int target) {
            if (target == 0) {
                return 0;
            } else {
                target = Math.abs(target);
                int minBatch = (int) Math.ceil((Math.sqrt(8L * target + 1L) - 1D) / (2D));
                int group = (minBatch + 1) / 2;
                if (group % 2 == target % 2) {
                    return minBatch;
                } else {
                    return (group + 1) * 2 - 1;
                }
            }
        }
    }
}
