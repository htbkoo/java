package online.leetcode;

/*

https://leetcode.com/problems/number-of-segments-in-a-string/

Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5

*/

import java.util.Arrays;

public class NumberOfSegmentsInAString_slow {
    static class Solution {
        public int countSegments(String s) {
            return (int) Arrays.stream(s.split(" "))
                    .filter(substr -> !substr.isEmpty())
                    .count();
        }
    }
}
