package interview.cci.ch1ArraysAndStrings;

import java.util.Arrays;

public class CheckPermutation2 {
    private static final int ASCII_RANGE = 256;

    public static boolean arePermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        } else if (s1.length() == 0) {
            return true;
        } else {
            int[] occurrences = new int[ASCII_RANGE];

            Arrays.stream(s1.split("")).map(c -> c.codePointAt(0)).forEach(c -> occurrences[c]++);
            Arrays.stream(s2.split("")).map(c -> c.codePointAt(0)).forEach(c -> occurrences[c]--);

            return Arrays.stream(occurrences).allMatch(occurrence -> occurrence == 0);

        }
    }

    public static boolean arePermutationBySort(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        } else {
            return sort(s1).equals(sort(s2));
        }
    }

    private static String sort(String s) {
        final char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
