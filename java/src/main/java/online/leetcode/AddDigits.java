package online.leetcode;

/**
 * Created by Hey on 13/10/15
 */

/*

https://leetcode.com/problems/add-digits/

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

*/

public class AddDigits {
    public int addDigits(int num) {
        if (num == 0) return 0;
        int out = num % 9;
        return (out == 0) ? 9 : (out);
    }
}
