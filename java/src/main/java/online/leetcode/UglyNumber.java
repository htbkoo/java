package online.leetcode;

/**
 * Created by Hey on 25/10/15
 */

/*

https://leetcode.com/problems/ugly-number/

Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
*/

public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }

        num = getNumWithoutPrimeFactor(num, 2);
        num = getNumWithoutPrimeFactor(num, 3);
        num = getNumWithoutPrimeFactor(num, 5);

        return (num == 1);
    }

    private int getNumWithoutPrimeFactor(int num, int primeFactor) {
        while (num % primeFactor == 0) {
            num /= primeFactor;
        }
        return num;
    }
}
