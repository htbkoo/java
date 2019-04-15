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
        private static final String ONE_MINUTE = "one minute";
        private static final String SPACE_SEPARATED = " ";
        private static final String MINUTES = "minutes";

        private static String asMinutesOrQuarter(String descriptor, int h, int m) {
            if (isQuarter(m)) {
                return asQuarter(descriptor, h);
            } else if (isOneMinute(m)) {
                return asOneMinute(descriptor, h);
            } else {
                return asMinutes(descriptor, h, m);
            }
        }

        private static boolean isOneMinute(int m) {
            return m == 1;
        }

        private static boolean isQuarter(int m) {
            return m % MINUTES_IN_QUARTER == 0;
        }


        private static boolean isHalfHour(int m) {
            return m == 30;
        }

        private static boolean isOClock(int m) {
            return m == 0;
        }

        private static boolean isFirstHalfHour(int m) {
            return m < 30;
        }

        private static String spaceSeparated(String... parts) {
            return String.join(SPACE_SEPARATED, parts);
        }

        private static String asOClock(int h) {
            return spaceSeparated(intToWord(h), O_CLOCK);
        }

        private static String asHalfPast(int h) {
            return spaceSeparated(HALF_PAST, intToWord(h));
        }

        private static String asQuarter(String descriptor, int h) {
            return spaceSeparated(QUARTER, descriptor, intToWord(h));
        }

        private static String asOneMinute(String descriptor, int h) {
            return spaceSeparated(ONE_MINUTE, descriptor, intToWord(h));
        }

        private static String asMinutes(String descriptor, int h, int m) {
            return spaceSeparated(intToWord(m), MINUTES, descriptor, intToWord(h));
        }

        static String intToWord(int i) {
            if (i < 20) {
                return SPECIAL_INT_TO_WORD_MAPPING[i];
            } else {
                return ordinaryMapping(i);
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

        private static String ordinaryMapping(int i) {
            String tenthWord = getTenthWord(i / 10);
            int unitDigit = i % 10;
            if (unitDigit == 0) {
                return tenthWord;
            } else {
                return tenthWord + " " + SPECIAL_INT_TO_WORD_MAPPING[unitDigit];
            }
        }

        // Complete the timeInWords function below.
        static String timeInWords(int h, int m) {
            if (isOClock(m)) {
                return asOClock(h);
            } else if (isHalfHour(m)) {
                return asHalfPast(h);
            } else {
                if (isFirstHalfHour(m)) {
                    return asMinutesOrQuarter(PAST, h, m);
                } else {
                    int hNext = h + 1;
                    int mFromNextHour = MINUTES_IN_HOUR - m;
                    return asMinutesOrQuarter(TO, hNext, mFromNextHour);
                }
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
