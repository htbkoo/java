package online.leetcode;

/*

https://leetcode.com/problems/reverse-only-letters/

Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.



Example 1:

Input: "ab-cd"
Output: "dc-ba"

Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"



Note:

    S.length <= 100
    33 <= S[i].ASCIIcode <= 122
    S doesn't contain \ or "

*/

public class ReverseOnlyLetters {
    static class Solution {
        public String reverseOnlyLetters(String S) {
            int length = S.length();

            char[] chars = S.toCharArray();

            int lo = 0, hi = length - 1;
            while (lo < hi) {
                boolean isLoLetter = isLetter(chars[lo]), isHiLetter = isLetter(chars[hi]);
                if (isLoLetter && isHiLetter) {
                    char temp = chars[lo];
                    chars[lo] = chars[hi];
                    chars[hi] = temp;
                    lo++;
                    hi--;
                } else {
                    if (!isLoLetter) {
                        lo++;
                    }
                    if (!isHiLetter) {
                        hi--;
                    }
                }
            }

            return new String(chars);
        }

        private boolean isLetter(char ch) {
            return isBigLetter(ch) || isSmallLetter(ch);
        }

        private boolean isBigLetter(char ch) {
            return 'A' <= ch && ch <= 'Z';
        }

        private boolean isSmallLetter(char ch) {
            return 'a' <= ch && ch <= 'z';
        }
    }
}
