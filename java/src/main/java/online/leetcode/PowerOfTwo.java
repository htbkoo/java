package online.leetcode;

/**
 * Created by Hey on 29/11/15
 */

/*

https://leetcode.com/problems/power-of-two/

Given an integer, write a function to determine if it is a power of two.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return n == 1;
    }
}
