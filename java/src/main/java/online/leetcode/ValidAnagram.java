package online.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hey on 13/11/15
 */

/*

https://leetcode.com/problems/valid-anagram/

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

Subscribe to see which companies asked this question

*/

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Integer> sCount = countForCharacterArray(sChars);
        Map<Character, Integer> tCount = countForCharacterArray(tChars);

        return sCount.equals(tCount);
    }

    private Map<Character, Integer> countForCharacterArray(char[] chars) {
        Map<Character, Integer> count = new HashMap<>();

        for (char c : chars) {
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        return count;
    }
}
