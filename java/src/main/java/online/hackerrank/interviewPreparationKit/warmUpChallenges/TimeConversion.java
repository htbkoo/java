package online.hackerrank.interviewPreparationKit.warmUpChallenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeConversion {
    public static class Solution {
        private static class Time {
            private static final Pattern PATTERN_12_HOUR_FORMAT = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})(\\w{2})");
            private static final String MID_NIGHT_HOUR_24 = "00";
            private static final int HOURS_IN_HALF_DAY = 12;

            final String hour;
            final String minute;
            final String second;
            final AmPm amPm;

            Time(String hour, String minute, String second, AmPm amPm) {
                this.hour = hour;
                this.minute = minute;
                this.second = second;
                this.amPm = amPm;
            }

            static Time fromString(String s) {
                Matcher matcher = PATTERN_12_HOUR_FORMAT.matcher(s);
                boolean matched = matcher.find();
                if (matched) {
                    String hour = matcher.group(1);
                    String minute = matcher.group(2);
                    String second = matcher.group(3);
                    AmPm amPm = AmPm.valueOf(matcher.group(4));

                    return new Time(hour, minute, second, amPm);
                } else {
                    throw new IllegalArgumentException("Unable to recognize string: " + s);
                }
            }

            String in24HourFormat() {
                String newHour = getNewHour();
                return String.format("%s:%s:%s", newHour, this.minute, this.second);
            }

            private String getNewHour() {
                if (isMidNightHour()) {
                    return MID_NIGHT_HOUR_24;
                } else if (isPM())
                    return String.valueOf(((Integer.parseInt(this.hour) % HOURS_IN_HALF_DAY + this.amPm.adjustment)));
                else {
                    return this.hour;
                }
            }

            private boolean isMidNightHour() {
                return AmPm.AM.equals(this.amPm) && "12".equals(this.hour);
            }

            private boolean isPM() {
                return AmPm.PM.equals(this.amPm);
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
            Time time = Time.fromString(s);
            return time.in24HourFormat();
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
