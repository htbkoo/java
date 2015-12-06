package online.leetcode;

/**
 * Created by Hey on 5/12/15
 */

/*

https://leetcode.com/problems/factorial-trailing-zeroes/

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int sum = 0;
        long cur = 5;
        while (cur <= n) {
            sum += n / cur;
            cur *= 5;
        }
        return sum;
    }
}
