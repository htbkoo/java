package online.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hey on 13/1/16
 */

/*

https://leetcode.com/problems/isomorphic-strings/

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.

Subscribe to see which companies asked this question

*/

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        //            by assumption, You may assume both s and t have the same length.
        if (s.length() != t.length()) {
            return false;
        }
        char[] map = new char[512];
        char[] reverseMap = new char[512];
        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();

        final int length = s_chars.length;
        for (int i = 0; i < length; ++i) {
            if (map[s_chars[i]] != Character.MIN_VALUE) {
                if (t_chars[i] != map[s_chars[i]]) {
                    return false;
                }
            } else {
                map[s_chars[i]] = t_chars[i];
            }
            if (reverseMap[t_chars[i]] != Character.MIN_VALUE) {
                if (s_chars[i] != reverseMap[t_chars[i]]) {
                    return false;
                }
            } else {
                reverseMap[t_chars[i]] = s_chars[i];
            }
        }
        return true;
    }

    private class SlowApproachUsingMap {
        public boolean isIsomorphic(String s, String t) {
            //            by assumption, You may assume both s and t have the same length.
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Character> map = new HashMap<>();
            Map<Character, Character> reverseMap = new HashMap<>();
            char[] s_chars = s.toCharArray();
            char[] t_chars = t.toCharArray();

            final int length = s_chars.length;
            for (int i = 0; i < length; ++i) {
                if (map.containsKey(s_chars[i])) {
                    if (t_chars[i] != map.get(s_chars[i])) {
                        return false;
                    }
                } else {
                    map.put(s_chars[i], t_chars[i]);
                }
                if (reverseMap.containsKey(t_chars[i])) {
                    if (s_chars[i] != reverseMap.get(t_chars[i])) {
                        return false;
                    }
                } else {
                    reverseMap.put(t_chars[i], s_chars[i]);
                }
            }
            return true;
        }
    }
}
