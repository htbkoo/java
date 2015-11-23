package online.leetcode;

/**
 * Created by Hey on 21/11/15
 */

/*

https://leetcode.com/problems/climbing-stairs/

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Subscribe to see which companies asked this question


*/

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 2) return n;
        int[] ways = new int[n + 1];
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i <= n; ++i) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }
}
