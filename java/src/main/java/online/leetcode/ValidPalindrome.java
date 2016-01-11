package online.leetcode;

/**
 * Created by Hey on 12/1/16
 */

/*

https://leetcode.com/problems/valid-palindrome/

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Subscribe to see which companies asked this question

*/

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
//        s = s.replace(" ", "").toLowerCase();
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        final int length = s.length();
        if (length <= 1) {
            return true;
        }

        for (int i = 0; i < length / 2; ++i) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
