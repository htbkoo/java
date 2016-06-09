package online.codewars._5kyu;

import java.util.Arrays;

/**
 * Created by Hey on 8 June 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/scramblies
 */

/*

Write function scramble(str1,str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.

For example:
str1 is 'rkqodlw' and str2 is 'world' the output should return true.
str1 is 'cedewaraaossoqqyt' and str2 is 'codewars' should return true.
str1 is 'katas' and str2 is 'steak' should return false.

Only lower case letters will be used (a-z). No punctuation or digits will be included.
Performance needs to be considered

* */

public class Scramblies {

    public static boolean scramble(String str1, String str2) {
        // your code
        int[] frequencies = new int[26];
        final char[] chars1 = str1.toCharArray();
        final char[] chars2 = str2.toCharArray();
        for (char c : chars1) {
            ++frequencies[c - 'a'];
        }
        for (char c : chars2) {
            --frequencies[c - 'a'];
        }
        for (int f : frequencies) {
            if (f < 0) {
                return false;
            }
        }
        return true;
    }

    private static class Java8CleanSlowApproach {

        public static boolean scramble(String str1, String str2) {
            // your code
            int[] frequencies = new int[26];
            str1.chars().forEach(c -> ++frequencies[c - 'a']);
            str2.chars().forEach(c -> --frequencies[c - 'a']);
            return (Arrays.stream(frequencies).allMatch(f -> f >= 0));
        }

    }
}