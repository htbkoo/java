package online.codewars._5kyu;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Hey on 9 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/common-denominators/train/java
 */

/*

Common denominators

You will have a list of rationals in the form

 { {numer_1, denom_1} , ... {numer_n, denom_n} }

where all numbers are positive ints.

You have to produce a result in the form

 (N_1, D) ... (N_n, D)

in which D is as small as possible and

 N_1/D == numer_1/denom_1 ... N_n/D == numer_n,/denom_n.

Example :

 { {1, 2}, {1, 3}, {1, 4} } produces the string (6,12)(4,12)(3,12)

* */

@SuppressWarnings("WeakerAccess")
public class CommonDenominators {
    public static class Fracts {

        public static final int NUMERATOR_POS_IN_ARRAY = 0;
        public static final int DENOMINATOR_POS_IN_ARRAY = 1;

        // your code
        public static String convertFrac(long[][] lst) {
            final long[] denominators = getAllDenominators(lst);
            final long lcd = getLeastCommonDenominator(denominators);
            // your code
            return getPairs(lst, lcd);
        }

        private static String getPairs(long[][] lst, long lcd) {
            return Arrays.
                    stream(lst).
                    map(ls -> String.format("(%d,%d)", lcd * ls[NUMERATOR_POS_IN_ARRAY] / ls[DENOMINATOR_POS_IN_ARRAY], lcd)).
                    collect(Collectors.joining());
        }

        private static long[] getAllDenominators(long[][] lst) {
            return Arrays.stream(lst).mapToLong(ls -> ls[DENOMINATOR_POS_IN_ARRAY]).toArray();
        }

        private static long getLeastCommonDenominator(long[] denominators) {
            return Arrays.stream(denominators).reduce((a, b) -> (a * b / lcd(a, b))).orElse(1L);
        }

        public static long lcd(long a, long b) {
            a = Math.abs(a);
            b = Math.abs(b);
            while (b != 0) {
                long t = b;
                b = a % b;
                a = t;
            }
            return a;
        }

    }

    public static class FailedAttemptFracts {

        public static final int NUMERATOR_POS_IN_ARRAY = 0;
        public static final int DENOMINATOR_POS_IN_ARRAY = 1;

        // your code
        public static String convertFrac(long[][] lst) {
            final long[] denominators = getAllDenominators(lst);
            final long gcd = getGreatestCommonDivisor(denominators);
            // your code
            final long multiplies = Arrays.stream(denominators).reduce((a, b) -> a * b).orElse(1L);
            return getPairs(lst, multiplies / gcd);
        }

        private static String getPairs(long[][] lst, long lcd) {
            return Arrays.
                    stream(lst).
                    map(ls -> String.format("(%d,%d)", lcd * ls[NUMERATOR_POS_IN_ARRAY] / ls[DENOMINATOR_POS_IN_ARRAY], lcd)).
                    collect(Collectors.joining());
        }

        private static long[] getAllDenominators(long[][] lst) {
            return Arrays.stream(lst).mapToLong(ls -> ls[DENOMINATOR_POS_IN_ARRAY]).toArray();
        }

        private static long getGreatestCommonDivisor(long[] denominators) {
            return Arrays.stream(denominators).reduce(Fracts::lcd).orElse(1L);
        }

        public static long lcd(long a, long b) {
            a = Math.abs(a);
            b = Math.abs(b);
            while (b != 0) {
                long t = b;
                b = a % b;
                a = t;
            }
            return a;
        }

    }
}
