package online.leetcode;

/**
 * Created by Hey on 2 Jul 16
 */

/*

https://leetcode.com/problems/valid-perfect-square/

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True

Example 2:

Input: 14
Returns: False

Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num<=0){
            return false;
        }
        for (long i = 0, sq = 0; sq <= num; ++i, sq = i * i) {
            if (num == sq) {
                return true;
            }
        }
        return false;
    }
}

