package online.leetcode;

/*

https://leetcode.com/problems/find-all-anagrams-in-a-string/

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    static class Solution {
        private static final int ASCII_RANGE = 256;

        public List<Integer> findAnagrams(String s, String p) {
            if (s.isEmpty() || s.length() < p.length()) {
                return new ArrayList<>();
            } else {
                int[] pFreq = countFreq(p);
                int sLength = s.length(), pLength = p.length();
                int[] sSubstringFreq = countFreq(s.substring(0, pLength));

                List<Integer> answers = new ArrayList<>();
                if (Arrays.equals(sSubstringFreq, pFreq)) {
                    answers.add(0);
                }

                for (int start = 1; start <= sLength - pLength; ++start) {
                    sSubstringFreq[s.codePointAt(start - 1)]--;
                    sSubstringFreq[s.codePointAt(pLength + start - 1)]++;
                    if (Arrays.equals(sSubstringFreq, pFreq)) {
                        answers.add(start);
                    }
                }

                return answers;
            }
        }

        private int[] countFreq(String str) {
            int[] freq = new int[ASCII_RANGE];
            str.chars().forEach(c -> freq[c]++);
            return freq;
        }
    }
}
