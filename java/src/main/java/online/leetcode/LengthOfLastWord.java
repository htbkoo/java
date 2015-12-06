package online.leetcode;

/**
 * Created by Hey on 6/12/15
 */

/*

https://leetcode.com/problems/length-of-last-word/

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5.

Subscribe to see which companies asked this question

*/

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.length()==0){
            return 0;
        }

        s = s.trim();
        final int lastIndexOfSpace = s.lastIndexOf(' ');
        if (lastIndexOfSpace < 0) {
            return s.length();
        } else {
            return s.length() - (lastIndexOfSpace + 1);
        }
    }
}
