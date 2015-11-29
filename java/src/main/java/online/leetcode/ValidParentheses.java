package online.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Hey on 28/11/15
 */

/*

https://leetcode.com/problems/valid-parentheses/

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Subscribe to see which companies asked this question

*/

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> prev = new ArrayDeque<>();
        final char[] chars = s.toCharArray();
        for (char c : chars) {
            if ((c == '(') || (c == '{') || (c == '[')) {
                prev.push(c);
            } else {
                if (prev.isEmpty()) {
                    return false;
                } else {
                    if (!isMatch(prev.pop(), c)) {
                        return false;
                    }
                }
            }
        }
        return prev.isEmpty();
    }

    private boolean isMatch(char last, char current) {
        switch (last) {
            case '(':
                return current == ')';
            case '{':
                return current == '}';
            case '[':
                return current == ']';
            default:
                throw new IllegalArgumentException("Problem assumption invalid - string should contain just the characters '(', ')', '{', '}', '[' and ']'");
//            default:
//                return false;
        }
    }
}
