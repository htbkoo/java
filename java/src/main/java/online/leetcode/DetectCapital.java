package online.leetcode;

/*

https://leetcode.com/problems/detect-capital/

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital if it has more than one letter, like "Google".

Otherwise, we define that this word doesn't use capitals in a right way.

Example 1:

Input: "USA"
Output: True

Example 2:

Input: "FlaG"
Output: False

Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.

*/

public class DetectCapital {
    static class Solution {
        public boolean detectCapitalUse(String word) {
            char[] chars = word.toCharArray();

            return isAllCapital(chars) || isAllSmall(chars) || isOnlyFirstLetterCapital(chars);
        }

        private boolean isAllCapital(char[] chars) {
            for (char ch : chars) {
                if (isNotCapital(ch)) {
                    return false;
                }
            }

            return true;
        }

        private boolean isNotCapital(char ch) {
            return ('A' > ch || ch > 'Z');
        }

        private boolean isAllSmall(char[] chars) {
            for (char ch : chars) {
                if (isNotSmall(ch)) {
                    return false;
                }
            }

            return true;
        }


        private boolean isNotSmall(char ch) {
            return ('a' > ch || ch > 'z');
        }

        private boolean isOnlyFirstLetterCapital(char[] chars) {
            if (chars.length == 0) {
                throw new IllegalArgumentException("word is empty");
            } else {
                if (isNotCapital(chars[0])) {
                    return false;
                }
                for (int i = 1, length = chars.length; i < length; ++i) {
                    if (isNotSmall(chars[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
