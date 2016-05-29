package online.codewars._4kyu;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Hey on 28 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/catching-car-mileage-numbers/train/java
 */

/*

    "7777...8?!??!", exclaimed Bob, "I missed it again! Argh!" Every time there's an interesting number coming up, he notices and then promptly forgets. Who doesn't like catching those one-off interesting mileage numbers?

Let's make it so Bob never misses another interesting number. We've hacked into his car's computer, and we have a box hooked up that reads mileage numbers. We've got a box glued to his dash that lights up yellow or green depending on whether it receives a 1 or a 2 (respectively).

It's up to you, intrepid warrior, to glue the parts together. Write the function that parses the mileage number input, and returns a 2 if the number is "interesting" (see below), a 1 if an interesting number occurs within the next two miles, or a 0 if the number is not interesting.

Note: In Haskell, we use No, Almost and Yes instead of 0, 1 and 2.
"Interesting" Numbers

Interesting numbers are 3-or-more digit numbers that meet one or more of the following criteria:

    Any digit followed by all zeros: 100, 90000
    Every digit is the same number: 1111
    The digits are sequential, incementing†: 1234
    The digits are sequential, decrementing‡: 4321
    The digits are a palindrome: 1221 or 73837
    The digits match one of the values in the awesomePhrases array

    † For incrementing sequences, 0 should come after 9, and not before 1, as in 7890.
    ‡ For decrementing sequences, 0 should come after 1, and not before 9, as in 3210.

So, you should expect these inputs and outputs:

// "boring" numbers
CarMileage.isInteresting(3, new int[]{1337, 256});    // 0
CarMileage.isInteresting(3236, new int[]{1337, 256}); // 0

// progress as we near an "interesting" number
CarMileage.isInteresting(11207, new int[]{}); // 0
CarMileage.isInteresting(11208, new int[]{}); // 0
CarMileage.isInteresting(11209, new int[]{}); // 1
CarMileage.isInteresting(11210, new int[]{}); // 1
CarMileage.isInteresting(11211, new int[]{}); // 2

// nearing a provided "awesome phrase"
CarMileage.isInteresting(1335, new int[]{1337, 256}); // 1
CarMileage.isInteresting(1336, new int[]{1337, 256}); // 1
CarMileage.isInteresting(1337, new int[]{1337, 256}); // 2

Error Checking

    A number is only interesting if it is greater than 99!
    Input will always be an integer greater than 0, and less than 1,000,000,000.
    The awesomePhrases array will always be provided, and will always be an array, but may be empty. (Not everyone thinks numbers spell funny words...)
    You should only ever output 0, 1, or 2.

* */

public class CatchingCarMileageNumbers {
    public static class CarMileage {

        private interface InterestingCriterion {
            boolean isfulfill(final int number, final int[] awesomePhrases);
        }

        private static final int ALMOST_INTERESTING_DIFFERENCE_THRESHOLD = 2;
        private static final int MIN_INTERESTING_NUMBER = 100;
        private static final List<InterestingCriterion> criteria = Arrays.asList(
                (CarMileage::isFollowedByAllZeros),
                (CarMileage::isAllSameDigits),
                (CarMileage::isIncrementingSequential),
                (CarMileage::isDecrementingSequential),
                (CarMileage::isPalindrome),
                (CarMileage::isInArray)

        );

        private static boolean isFollowedByAllZeros(int number, final int[] awesomePhrases) {
            while (number > 10) {
                if (number % 10 != 0) {
                    return false;
                }
                number /= 10;
            }
            return true;
        }

        private static boolean isAllSameDigits(int number, final int[] awesomePhrases) {
            final int digit = number % 10;
            while (number >= 10) {
                number /= 10;
                if (number % 10 != digit) {
                    return false;
                }
            }
            return number % 10 == digit;
        }

        private static boolean isIncrementingSequential(int number, final int[] awesomePhrases) {
            int digit = number % 10 - 1;
            if (digit < 0) {
                digit += 10;
            }
            while (number >= 10) {
                number /= 10;
                if (number % 10 != digit) {
                    return false;
                }
                --digit;
            }
            return true;
        }

        private static boolean isDecrementingSequential(int number, final int[] awesomePhrases) {
            int digit = number % 10 + 1;
            while (number >= 10) {
                number /= 10;
                if (number % 10 != digit) {
                    return false;
                }
                ++digit;
            }
            return true;
        }

        private static boolean isPalindrome(final int number, final int[] awesomePhrases) {
            final StringBuilder s = new StringBuilder(String.valueOf(number));
            return s.toString().equals(s.reverse().toString());
        }

        private static boolean isInArray(final int number, final int[] awesomePhrases) {
            return Arrays.stream(awesomePhrases).anyMatch(phrase -> phrase == number);
        }

        private enum Interestingness {
            NO(0), ALMOST(1), YES(2);
            private final int intValue;

            Interestingness(int intValue) {
                this.intValue = intValue;
            }

            public int asInt() {
                return intValue;
            }
        }

        public static int isInteresting(int number, int[] awesomePhrases) {
            //Go to town
            if (isInterestingPossible(number)) {
                if (fulfillCriteria(number, awesomePhrases)) {
                    return Interestingness.YES.asInt();
                }
                if (isAlmostInteresting(number, awesomePhrases)) {
                    return Interestingness.ALMOST.asInt();
                }
                return Interestingness.NO.asInt();
            } else if (isAlmostInterestingPossible(number)) {
                if (isAlmostInteresting(number, awesomePhrases)) {
                    return Interestingness.ALMOST.asInt();
                }
                return Interestingness.NO.asInt();
            }
            return Interestingness.NO.asInt();
        }

        private static boolean isInterestingPossible(int number) {
            return number >= MIN_INTERESTING_NUMBER;
        }

        private static boolean isAlmostInterestingPossible(final int number) {
            return MIN_INTERESTING_NUMBER - number <= ALMOST_INTERESTING_DIFFERENCE_THRESHOLD;
        }

        private static boolean isAlmostInteresting(final int number, final int[] awesomePhrases) {
            for (int delta = 1; delta <= ALMOST_INTERESTING_DIFFERENCE_THRESHOLD; ++delta) {
                if (fulfillCriteria(number + delta, awesomePhrases)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean fulfillCriteria(final int number, final int[] awesomePhrases) {
            return criteria.stream().anyMatch(criterion -> criterion.isfulfill(number, awesomePhrases));
        }
    }

}
