package online.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Hey on 19/1/16
 */

/*

https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
1=_
2=abc
3=def
4=ghi
5=jkl
6=mno
7=pqrs
8=tuv
9=wxyz

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.

Subscribe to see which companies asked this question


*/

public class LetterCombinationsOfAPhoneNumber {
    //    2ms, will be 3ms if ArrayList instead of char[] is used
    public List<String> letterCombinations(String digits) {
        final int length = digits.length();
        List<String> prevCombinations = new ArrayList<>();
        prevCombinations.add("");
        List<String> combinations = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            combinations = new ArrayList<>();
            final char digit = digits.charAt(i);
            char[] characters;
            switch (digit) {
                case '2': {
                    characters = new char[]{'a', 'b', 'c'};
                    break;
                }
                case '3': {
                    characters = new char[]{'d', 'e', 'f'};
                    break;
                }
                case '4': {
                    characters = new char[]{'g', 'h', 'i'};
                    break;
                }
                case '5': {
                    characters = new char[]{'j', 'k', 'l'};
                    break;
                }
                case '6': {
                    characters = new char[]{'m', 'n', 'o'};
                    break;
                }
                case '7': {
                    characters = new char[]{'p', 'q', 'r', 's'};
                    break;
                }
                case '8': {
                    characters = new char[]{'t', 'u', 'v'};
                    break;
                }
                case '9': {
                    characters = new char[]{'w', 'x', 'y', 'z'};
                    break;
                }
                default: {
                    return Collections.emptyList();
                }
            }
            for (char character : characters) {
                for (String str : prevCombinations) {
                    combinations.add(str + character);
                }
            }
            prevCombinations = combinations;
        }
        return combinations;
    }

    private static class FailedComplicatedSlowApproachUsingCollections {
        private static Map<Character, List<Character>> MAPPING = new HashMap<Character, List<Character>>() {{
            put('2', Arrays.asList('a', 'b', 'c'));
            put('3', Arrays.asList('d', 'e', 'f'));
            put('4', Arrays.asList('g', 'h', 'i'));
            put('5', Arrays.asList('j', 'k', 'l'));
            put('6', Arrays.asList('m', 'n', 'o'));
            put('7', Arrays.asList('p', 'q', 'r', 's'));
            put('8', Arrays.asList('t', 'u', 'v'));
            put('9', Arrays.asList('w', 'x', 'y', 'z'));
        }};

        private final class ComparableStringBuilder implements Comparator<ComparableStringBuilder> {

            private StringBuilder stringBuilder;

            public ComparableStringBuilder() {
                this.stringBuilder = new StringBuilder();
            }

            @Override
            public int compare(ComparableStringBuilder o1, ComparableStringBuilder o2) {
                return o1.stringBuilder.toString().compareTo(o2.stringBuilder.toString());
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof ComparableStringBuilder)) {
                    return false;
                }
                ComparableStringBuilder o2 = (ComparableStringBuilder) obj;
                return this.stringBuilder.toString().equals(o2.stringBuilder.toString());
            }

            public String getString() {
                return stringBuilder.toString();
            }

            public void append(char c) {
                stringBuilder.append(c);
            }
        }

        public List<String> letterCombinations(String digits) {
            final int length = digits.length();
            if (length == 0) {
                return Collections.<String>emptyList();
            }

            List<String> combinations = new ArrayList<>();
            final List<Character> mapped_chars_for_first = MAPPING.get(digits.charAt(0));
            for (Character mapped_char : mapped_chars_for_first) {
                combinations.add(String.valueOf(mapped_char));
            }

            for (int i = 1; i < length; i++) {
                char c = digits.charAt(i);
                final List<Character> characters = MAPPING.get(c);
                Set<String> tempSet = new HashSet<>();
                for (Character mapped_char : characters) {
                    for (String s : combinations) {
                        tempSet.add(s + mapped_char);
                    }
                }
                combinations = new ArrayList<>(tempSet);
            }
            return combinations;
        }
    }

    //    4ms
    private static class SlowApproachUsingCollections {
        private static Map<Character, List<Character>> MAPPING = new HashMap<Character, List<Character>>() {{
            put('2', Arrays.asList('a', 'b', 'c'));
            put('3', Arrays.asList('d', 'e', 'f'));
            put('4', Arrays.asList('g', 'h', 'i'));
            put('5', Arrays.asList('j', 'k', 'l'));
            put('6', Arrays.asList('m', 'n', 'o'));
            put('7', Arrays.asList('p', 'q', 'r', 's'));
            put('8', Arrays.asList('t', 'u', 'v'));
            put('9', Arrays.asList('w', 'x', 'y', 'z'));
        }};

        public List<String> letterCombinations(String digits) {
            final int length = digits.length();
            List<String> prevCombinations = new ArrayList<>();
            prevCombinations.add("");
            List<String> combinations = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                combinations = new ArrayList<>();
                final char digit = digits.charAt(i);
                if (!MAPPING.containsKey(digit)) {
                    return Collections.emptyList();
                }
                final List<Character> characters = MAPPING.get(digit);
                for (Character character : characters) {
                    for (String str : prevCombinations) {
                        combinations.add(str + character);
                    }
                }
                prevCombinations = combinations;
            }
            return combinations;
        }
    }
}
