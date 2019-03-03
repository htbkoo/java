package interview.cci.ch1ArraysAndStrings;

import java.util.Arrays;
import java.util.function.Predicate;

public class IsUnique1 {

    private static final int ASCII_RANGE = 256;

    public static boolean isUnique(String s) {
        boolean[] occurrences = new boolean[ASCII_RANGE];

        if (s.length() <= 1) {
            return true;
        } else {
            return Arrays.stream(s.split(""))
                    .map(c -> c.codePointAt(0))
                    .noneMatch(duplicatedCharCode(occurrences));
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
