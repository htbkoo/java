package online.leetcode;

/**
 * Created by Hey on 8/1/16
 */

/*

https://leetcode.com/problems/power-of-three/

Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        switch (n) {
            case 1:
            case 3:
            case 9:
            case 27:
            case 81:
            case 243:
            case 729:
            case 2187:
            case 6561:
            case 19683:
            case 59049:
            case 177147:
            case 531441:
            case 1594323:
            case 4782969:
            case 14348907:
            case 43046721:
            case 129140163:
            case 387420489:
            case 1162261467:
                return true;
            default:
                return false;
        }
    }

    private class RecursiveApproach {
        public boolean isPowerOfThree(int n) {
            while (n > 1) {
                if (n % 3 != 0) {
                    return false;
                }
                n /= 3;
            }
            return n == 1;
        }
    }
}
