package online.leetcode;

/**
 * Created by Hey on 28/4/16
 */

/*

https://leetcode.com/problems/reverse-string/

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

Subscribe to see which companies asked this question

*/

public class ReverseString {
    //    verbose approach, 3ms
    public String reverseString(String s) {
        final char[] chars = s.toCharArray();
        final int length = s.length();
        final char[] reversed = new char[length];
        int index = length - 1;
        for (char c : chars) {
            reversed[index] = c;
            --index;
        }

        return new String(reversed);
    }

    private class StringBuilderReverseApproach {
        //    StringBuilder reverse approach, 4ms
        public String reverseString(String s) {
            return new StringBuilder(s).reverse().toString();
        }
    }
}
