package online.hackerrank.interviewPreparationKit.warmUpChallenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeConversion {
    public static class Solution {
        private static final Pattern PATTERN_12_HOUR_FORMAT = Pattern.compile("(\\d{2}:\\d{2}:\\d{2})(\\w{2})");
        private static final String MIDNIGHT = "12:00:00AM";
        private static final String NOON = "12:00:00PM";
        private static final String MIDNIGHT_24 = "00:00:00";
        private static final String NOON_24 = "12:00:00";

        private static class Time {
            final String hour;
            final String minute;
            final String second;

            Time(String hour, String minute, String second) {
                this.hour = hour;
                this.minute = minute;
                this.second = second;
            }

            static Time fromString(String t) {
                String[] parts = t.split(":");
                return new Time(parts[0], parts[1], parts[2]);
            }
        }

        private enum AmPm {
            AM(0), PM(12);

            private final int adjustment;

            AmPm(int adjustment) {
                this.adjustment = adjustment;
            }
        }

        /*
         * Complete the timeConversion function below.
         */
        static String timeConversion(String s) {
            /*
             * Write your code here.
             */
            if (MIDNIGHT.equals(s)) {
                return MIDNIGHT_24;
            }
            if (NOON.equals(s)) {
                return NOON_24;
            }

            Matcher matcher = PATTERN_12_HOUR_FORMAT.matcher(s);
            matcher.find();
            Time time = Time.fromString(matcher.group(1));
            AmPm amPm = AmPm.valueOf(matcher.group(2));

            String newHour = time.hour;
            if (AmPm.PM.equals(amPm)) {
                newHour = String.valueOf(Integer.parseInt(time.hour) + amPm.adjustment);
            }

            return String.format("%s:%s:%s", newHour, time.minute, time.second);
        }

        private static final Scanner scan = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String s = scan.nextLine();

            String result = timeConversion(s);

            bw.write(result);
            bw.newLine();

            bw.close();
        }
    }

}
