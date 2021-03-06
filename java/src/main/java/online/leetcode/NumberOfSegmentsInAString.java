package online.leetcode;

/*

https://leetcode.com/problems/number-of-segments-in-a-string/

Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5

*/

public class NumberOfSegmentsInAString {
    static class Solution {
        public int countSegments(String s) {
            String[] substrs = s.split(" ");
            int count = 0;
            for (String substr : substrs) {
                if (!substr.isEmpty()) {
                    count++;
                }
            }
            return count;
        }
    }
}
