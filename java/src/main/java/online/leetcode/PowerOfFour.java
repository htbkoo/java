package online.leetcode;

/**
 * Created by Hey on 19/4/16
 */

/*

https://leetcode.com/problems/power-of-four/

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

Credits:
Special thanks to @yukuairoy for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class PowerOfFour {
//    2ms
    public boolean isPowerOfFour(int num) {
        switch (num) {
            case 1:
            case 4:
            case 16:
            case 64:
            case 256:
            case 1024:
            case 4096:
            case 16384:
            case 65536:
            case 262144:
            case 1048576:
            case 4194304:
            case 16777216:
            case 67108864:
            case 268435456:
            case 1073741824:
                return true;
            default:
                return false;
        }
    }

    private class RecursiveApproach {
        public boolean isPowerOfFour(int num) {
            while (num > 1) {
                if (num % 4 != 0) {
                    return false;
                }
                num /= 4;
            }
            return num == 1;
        }
    }
}
