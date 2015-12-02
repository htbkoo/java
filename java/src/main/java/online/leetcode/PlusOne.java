package online.leetcode;

import java.util.Arrays;

/**
 * Created by Hey on 29/11/15
 */

/*

https://leetcode.com/problems/plus-one/

Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Subscribe to see which companies asked this question

*/

public class PlusOne {
    public int[] plusOne(int[] digits) {
        final int length = digits.length;
        int[] returnValue = new int[length + 1];
        int cur = length;
        returnValue[cur] = digits[cur - 1] + 1;
        --cur;
        while (cur > 0) {
            if (returnValue[cur + 1] > 9) {
                returnValue[cur] = digits[cur - 1] + 1;
                returnValue[cur + 1] %= 10;
            } else {
                returnValue[cur] = digits[cur - 1];
            }
            --cur;
        }

        if (returnValue[1]>9){
            returnValue[0] = 1;
            returnValue[1] %= 10;
        }

        return (returnValue[0] > 0) ? returnValue : Arrays.copyOfRange(returnValue, 1, length + 1);
    }
}
