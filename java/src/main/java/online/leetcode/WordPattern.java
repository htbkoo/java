package online.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Hey on 23/1/16
 */

/*

https://leetcode.com/problems/word-pattern/

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:

    pattern = "abba", str = "dog cat cat dog" should return true.
    pattern = "abba", str = "dog cat cat fish" should return false.
    pattern = "aaaa", str = "dog cat cat dog" should return false.
    pattern = "abba", str = "dog dog dog dog" should return false.

Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

Credits:
Special thanks to @minglotus6 for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        final String[] split = str.split(" ");
        final char[] chars = pattern.toCharArray();

        final int length = chars.length;
        if (split.length != length) {
            return false;
        }

        Map<Character, String> mapping = new HashMap<>();
        Set<String> existing = new HashSet<>();
        for (int i = 0; i < length; ++i) {
            final char c = chars[i];
            final String s = split[i];
            if (mapping.containsKey(c)) {
                if (!mapping.get(c).equals(s)) {
                    return false;
                }
            } else {
                if (existing.contains(s)) {
                    return false;
                } else {
                    mapping.put(c, s);
                    existing.add(s);
                }
            }
        }

        return true;
    }
}
