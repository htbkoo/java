package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TheTimeInWords {
    public static class Solution {
        private static final String[] SPECIAL_INT_TO_WORD_MAPPING = {
                "zero",
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };
        private static final String TWENTY = "twenty";
        private static final String THIRTY = "thirty";
        private static final String FORTY = "forty";
        private static final String FIFTY = "fifty";
        private static final String O_CLOCK = "o' clock";
        private static final String HALF_PAST = "half past";
        private static final int MINUTES_IN_HOUR = 60;
        private static final int MINUTES_IN_QUARTER = 15;
        private static final String QUARTER = "quarter";
        private static final String PAST = "past";
        private static final String TO = "to";

        // Complete the timeInWords function below.
        static String timeInWords(int h, int m) {
            boolean isOClock = m == 0;
            boolean isHalfHour = m == 30;
            boolean isFirstHalfHour = m < 30;
            if (isOClock) {
                return asOClock(h);
            } else if (isHalfHour) {
                return asHalfPast(h);
            } else if (isFirstHalfHour) {
                return asMinutesOrQuarterPast(h, m);
            } else {
                int mFromNextHour = MINUTES_IN_HOUR - m;
                return asMinutesOrQuarterTo(h + 1, mFromNextHour);
            }
        }

        private static String asMinutesOrQuarterPast(int h, int m) {
            if (isQuarter(m)) {
                return asQuarter(PAST, h);
            } else if (isOneMinute(m)) {

            }

            return null;
        }

        private static boolean isOneMinute(int m) {
            return m == 1;
        }

        private static String asMinutesOrQuarterTo(int hNext, int mFromNextHour) {
            if (isQuarter(mFromNextHour)) {
                return asQuarter(TO, hNext);
            }

            return null;
        }

        private static boolean isQuarter(int m) {
            return m % MINUTES_IN_QUARTER == 0;
        }

        private static String asOClock(int h) {
            return intToWord(h) + " " + O_CLOCK;
        }

        private static String asHalfPast(int h) {
            return HALF_PAST + " " + intToWord(h);
        }

        private static String asQuarter(String descriptor, int h) {
            return QUARTER + " " + descriptor + " " + intToWord(h);
        }

        static String intToWord(int i) {
            if (i < 20) {
                return SPECIAL_INT_TO_WORD_MAPPING[i];
            } else {
                return ordinaryMapping(i);
            }
        }

        private static String ordinaryMapping(int i) {
            String tenthWord = getTenthWord(i / 10);
            int unitDigit = i % 10;
            if (unitDigit == 0) {
                return tenthWord;
            } else {
                return tenthWord + " " + SPECIAL_INT_TO_WORD_MAPPING[unitDigit];
            }
        }

        private static String getTenthWord(int tenthDigit) {
            switch (tenthDigit) {
                case 2:
                    return TWENTY;
                case 3:
                    return THIRTY;
                case 4:
                    return FORTY;
                case 5:
                    return FIFTY;
                default:
                    throw new IllegalArgumentException("Unrecognized tenthDigit: " + tenthDigit);
            }
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int h = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = timeInWords(h, m);

            bufferedWriter.write(result);
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
