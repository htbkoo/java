package online.codewars._6kyu;

/**
 * Created by Hey on 27 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/tortoise-racing/train/java
 */

/*

Two tortoises named A and B must run a race. A starts with an average speed of 720 feet per hour. Young B knows she runs faster than A and furthermore has not finished her cabbage.

When she starts, at last, she can see that A has a 70 feet lead but B speed is 850 feet per hour. How long will it take B to catch A?

More generally: given two speeds v1 (A speed, integer > 0) and v2 (B speed, integer > 0) and a lead g (integer > 0) how long will it take B to catch A?

The result will be an array [h, mn, s] where h, mn, s is the time needed in hours, minutes and seconds (don't worry for fractions of second). If v1 >= v2 then return nil, nothing, null, None or {-1, -1, -1} for C++.

Examples:

race(720, 850, 70) => [0, 32, 18]
race(80, 91, 37) => [3, 21, 49]

Note: you can see some other examples in "Your test cases".

* */

@SuppressWarnings("WeakerAccess")
public class TortoiseRacing {
    public static class Tortoise {
        public static int[] race(int v1, int v2, int g) {
            // your code
            if (v1 >= v2) {
                return null;
            }
            return getTimeNeeded(v1, v2, g);
        }

        private static int[] getTimeNeeded(int v1, int v2, int g) {
            final int chasePerHour = v2 - v1;
            int h = g / chasePerHour;
            double remainder = (double) (g - h * chasePerHour);
            final double chasePerMinute = (double) (chasePerHour) / 60.0;
            int mn = (int) (remainder / chasePerMinute);
            remainder = remainder - mn*chasePerMinute;
            final double chasePerSecond = chasePerMinute / 60.0;
            int s = (int) (remainder / chasePerSecond);
            return new int[]{h, mn, s};
        }
    }
}