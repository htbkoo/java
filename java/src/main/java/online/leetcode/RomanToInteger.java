package online.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by Hey on 17/11/15
 */

/*

https://leetcode.com/problems/roman-to-integer/

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Subscribe to see which companies asked this question

*/

public class RomanToInteger {
    private static Map<Character, Integer> ROMAN_LETTER_VALUE = Collections.unmodifiableMap(
            new HashMap<Character, Integer>() {{
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }}
    );

    private int getLetterValue(char c) {
        return ROMAN_LETTER_VALUE.get(c);
    }

    public int romanToInt(String s) {
        int sum = 0;
        final char[] chars = s.toUpperCase().toCharArray();
        int prevLetterValue = Integer.MAX_VALUE;
        for (char c : chars) {
            int currentLetterValue = getLetterValue(c);
            sum += currentLetterValue;
            if (currentLetterValue > prevLetterValue) {
                sum -= 2 * prevLetterValue;
            }
            prevLetterValue = currentLetterValue;
        }
        return sum;
    }

    private class RomanToIntegerWithStreamAPI {
        public int romanToInt(String s) {
            if (s.isEmpty()) {
                return 0;
            }
            return getLetterValue(s.charAt(0))
                    + IntStream.range(1, s.length()).
                    map(i -> {
                        int prevLetterValue = getLetterValue(s.charAt(i - 1));
                        int currentLetterValue = getLetterValue(s.charAt(i));
                        int sum = currentLetterValue;
                        if (currentLetterValue > prevLetterValue) {
                            sum -= 2 * prevLetterValue;
                        }
                        return sum;
                    }).sum();
        }
    }
}
