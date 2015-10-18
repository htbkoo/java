package online.leetcode;

/**
 * Created by Hey on 13/10/15
 */

/*

https://leetcode.com/problems/number-of-1-bits/

Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

*/

public class NumberOfOneBits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int hammingWeight;
        if (n >= 0) {
            hammingWeight = getHammingWeight(n);
        } else {
            long longn = (((long) Integer.MAX_VALUE) + 1) * 2 + (long) n;
            hammingWeight = getHammingWeight(longn);
        }
        return hammingWeight;
    }

    private int getHammingWeight(int n) {
        int hammingWeight = 0;
        while (n > 0) {
            if (n % 2 != 0) {
                hammingWeight++;
            }
            n = n >> 1;
        }
        return hammingWeight;
    }

    private int getHammingWeight(long n) {
        int hammingWeight = 0;
        while (n > 0) {
            if (n % 2 != 0) {
                hammingWeight++;
            }
            n = n >> 1;
        }
        return hammingWeight;
    }
}
