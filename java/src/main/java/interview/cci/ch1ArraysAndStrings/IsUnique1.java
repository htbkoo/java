package interview.cci.ch1ArraysAndStrings;

import java.util.Arrays;
import java.util.function.Predicate;

public class IsUnique1 {

    private static final int ASCII_RANGE = 256;

    public static boolean isUnique(String s) {
        if (s.length() <= 1) {
            return true;
        } else {
            boolean[] occurrences = new boolean[ASCII_RANGE];
            return Arrays.stream(s.split(""))
                    .map(c -> c.codePointAt(0))
                    .noneMatch(duplicatedCharCode(occurrences));
        }
    }

    public static boolean isUniqueWithoutAdditionDataStructure(String s) {
        if (s.length() <= 1) {
            return true;
        } else {
            final String[] chars = s.split("");
            for (int i = 0, length = chars.length; i < length; ++i) {
                for (int j = 0; j < length; ++j) {
                    if (i != j && chars[i].equals(chars[j])) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static Predicate<Integer> duplicatedCharCode(boolean[] occurrences) {
        return charCode -> {
            if (occurrences[charCode]) {
                return true;
            } else {
                occurrences[charCode] = true;
                return false;
            }
        };
    }
}
