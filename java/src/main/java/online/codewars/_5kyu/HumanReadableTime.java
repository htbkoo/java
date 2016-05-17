package online.codewars._5kyu;

/**
 * Created by Hey on 15 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/human-readable-time/train/java
 */

/*

Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)

    HH = hours, padded to 2 digits, range: 00 - 99
    MM = minutes, padded to 2 digits, range: 00 - 59
    SS = seconds, padded to 2 digits, range: 00 - 59

The maximum time never exceeds 359999 (99:59:59)

You can find some examples in the test fixtures.

* */

public class HumanReadableTime {
    //   better method from solution
    private static class BetterMethod {
        public static String makeReadable(int seconds) {
            // Do something
            return String.format("%02d:%02d:%02d", (seconds / 60) / 60, (seconds / 60) % 60, (seconds % 60));
//        return Integer.toString(seconds);
        }
    }

    public static String makeReadable(int seconds) {
        // Do something
        int hh = (seconds / 60) / 60, mm = (seconds / 60) % 60, ss = (seconds % 60);
        return String.format("%s:%s:%s", getFormattedTime(hh), getFormattedTime(mm), getFormattedTime(ss));
//        return Integer.toString(seconds);
    }

    private static String getFormattedTime(int digits) {
        return String.format("%02d", digits);
    }
}
