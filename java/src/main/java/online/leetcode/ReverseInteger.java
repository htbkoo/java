package online.leetcode;

/**
 * Created by Hey on 13/10/15
 */

/*

https://leetcode.com/problems/reverse-integer/

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

*/

public class ReverseInteger {
    public int reverse(int x) {
        try {
            return Integer.signum(x) * Integer.parseInt(new StringBuilder(String.valueOf(Math.abs(x))).reverse().toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public int reverseWithoutStringBuilder(int x) {
        int out = 0;
        int sign = (x < 0) ? -1 : 1;

        x = Math.abs(x);

        while ((x > 0) && (x % 10 == 0)) {
            x /= 10;
        }

        while (x > 0) {
            if (((long) out * 10) > Integer.MAX_VALUE) {
                return 0;
            }
            out *= 10;
            out += x % 10;
            x /= 10;
        }
        return sign * out;
    }
}
