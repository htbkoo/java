package online.codewars._4kyu;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Hey on 6 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/decimal-to-any-rational-or-irrational-base-converter/train/java
 */

/*

I started this as a joke among friends, telling that converting numbers to other integer bases is for n00bs, while an actual coder at least converts numbers to more complex bases like pi (or π or however you wish to spell it in your language), so they dared me proving I was better.

And I did it in few hours, discovering that what I started as a joke actually has some math ground and application (particularly the conversion to base pi, it seems).

That said, now I am daring you to do the same, that is to build a function so that it takes a number (any number, you are warned!) and optionally the number of decimals (default: 0) and a base (default: pi), returning the proper conversion as a string:
Note

In Java there is no easy way with optional parameters so all three parameters will be given; the same in C# because, as of now, the used version is not known.

Converter.converter(13, 0, Math.PI) #returns '103'
Converter.converter(13, 3, Math.PI) #returns '103.010'
Converter.converter(-13, 0, 2) #returns '-1101'

I know most of the world uses a comma as a decimal mark, but as English language and culture are de facto the Esperanto of us coders, we will stick to our common glorious traditions and uses, adopting the trivial dot (".") as decimal separator; if the absolute value of the result is <1, you have of course to put one (and only one) leading 0 before the decimal separator.

Finally, you may assume that decimals if provided will always be >= 0 and that no test base will be smaller than 2 (because, you know, converting to base 1 is pretty lame) or greater than 36; as usual, for digits greater than 9 you can use uppercase alphabet letter, so your base of numeration is going to be: '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'.

That is my first 3-languages-kata, so I count on you all to give me extensive feedback, no matter how harsh it may sound, so to improve myself even further :)

* */

@SuppressWarnings("WeakerAccess")
public class DecimalToAnyRationalOrIrrationalBaseConverter {
    public static class Converter {
        public static String converter(double n, int decimals, double base) {
            return getOptionalNegativeSign(n) + getMagnitudeString(n, decimals, base);
        }

        private static String getOptionalNegativeSign(double n) {
            return n < 0 ? "-" : "";
        }

        private static String getMagnitudeString(double n, int decimals, double base) {
            double m = Math.abs(n);
            final StringBuilder magnitudeString = new StringBuilder();
            final Deque<Double> powers = new ArrayDeque<>();

            double power;
            for (int index = 0; (power = Math.pow(base, index)) <= m; ++index) {
                powers.push(power);
            }

            while (!powers.isEmpty()) {
                final Double divider = powers.pop();
                final int quotient = (int) (m / divider);
                magnitudeString.append(mapIntToChar(quotient));
                m -= divider * quotient;
            }

            if (magnitudeString.length() == 0) {
                magnitudeString.append('0');
            }
            if (decimals > 0) {
                magnitudeString.append('.');
                magnitudeString.append(getDecimalPart(m, decimals, base));
            }
            return magnitudeString.toString();
        }

        private static String getDecimalPart(double remainder, int decimals, double base) {
            final StringBuilder magnitudeString = new StringBuilder();
            final Deque<Double> powers = new ArrayDeque<>();

            for (int index = -1; index >= -decimals; --index) {
                double power = Math.pow(base, index);
                powers.add(power);
            }

            while (!powers.isEmpty()) {
                final Double divider = powers.poll();
                final int quotient = (int) (remainder / divider);
                magnitudeString.append(mapIntToChar(quotient));
                remainder -= divider * quotient;
            }

            return magnitudeString.toString();
        }

        private static char mapIntToChar(int i) {
            return (char) (((i < 10) ? '0' : ('A' - 10)) + i);
        }
    }
}
