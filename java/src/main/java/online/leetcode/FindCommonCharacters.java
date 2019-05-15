package online.leetcode;

/*

https://leetcode.com/problems/find-common-characters/

Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.




Input: ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]



Note:

    1 <= A.length <= 100
    1 <= A[i].length <= 100
    A[i][j] is a lowercase letter

*/

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    static class Solution {

        private static final int LOWERCASE_LETTER_RANGE = 26;

        public List<String> commonChars(String[] A) {
            int[] commonFreq = countCharFreq(A[0]);
            for (int i = 1, length = A.length; i < length; ++i) {
                int[] freq = countCharFreq(A[i]);
                commonFreq = mergeForMin(commonFreq, freq);
            }

            return toCharactersList(commonFreq);
        }

        private int[] countCharFreq(String s) {
            int[] freq = new int[LOWERCASE_LETTER_RANGE];
            for (char ch : s.toCharArray()) {
                freq[charToInt(ch)]++;
            }
            return freq;
        }

        private int charToInt(char ch) {
            return ch - 'a';
        }

        private char intToChar(int i) {
            return (char) (i + 'a');
        }

        private int[] mergeForMin(int[] freq1, int[] freq2) {
            int[] freq = new int[LOWERCASE_LETTER_RANGE];
            for (int i = 0; i < LOWERCASE_LETTER_RANGE; ++i) {
                freq[i] = Math.min(freq1[i], freq2[i]);
            }
            return freq;
        }

        private ArrayList<String> toCharactersList(int[] commonFreq) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < LOWERCASE_LETTER_RANGE; ++i) {
                int occurrences = commonFreq[i];
                String ch = String.valueOf(intToChar(i));
                for (int j = 0; j < occurrences; ++j) {
                    list.add(ch);
                }
            }
            return list;
        }
    }
}
