package online.leetcode;

/*

https://leetcode.com/problems/ransom-note/

383. Ransom Note

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

*/

public class RansomNote {
    static class Solution {
        private static final int ASCII_RANGE = 256;

        public boolean canConstruct(String ransomNote, String magazine) {
            int[] ransomNoteFrequencies = countFrequency(ransomNote);
            int[] magazineFrequencies = countFrequency(magazine);

            for (int i = 0; i < ransomNoteFrequencies.length; i++) {
                if (ransomNoteFrequencies[i] > magazineFrequencies[i]) {
                    return false;
                }
            }

            return true;
        }

        private int[] countFrequency(String str) {
            int[] frequencies = new int[ASCII_RANGE];
            for (int i = 0, length = str.length(); i < length; ++i) {
                frequencies[str.codePointAt(i)]++;
            }
            return frequencies;
        }
    }
}
