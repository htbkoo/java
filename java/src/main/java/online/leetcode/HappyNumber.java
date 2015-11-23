package online.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Hey on 25/10/15
 */

/*

https://leetcode.com/problems/happy-number/

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1

Credits:
Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> loop = new HashSet<>();
        loop.add(n);
        while (n != 1) {
            n = getNextNum(n);
            if (loop.contains(n)) {
                return false;
            }
            loop.add(n);
        }
        return true;
    }

    protected static Map<Integer, Integer> digitSquare = new HashMap<Integer, Integer>() {{
        put(0, 0);
        put(1, 1);
        put(2, 4);
        put(3, 9);
        put(4, 16);
        put(5, 25);
        put(6, 36);
        put(7, 49);
        put(8, 64);
        put(9, 81);
    }};

    private int getNextNum(int n) {
        int nextNum = 0;
        while (n >= 10) {
            nextNum += digitSquare.get(n % 10);
            n /= 10;
        }
        return nextNum + digitSquare.get(n);
    }
}
