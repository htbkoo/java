package online.codewars._6kyu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hey on 14 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/5626b561280a42ecc50000d1/train/java
 */

/*

The number 89 is the first integer with more than one digit that fulfills the property partially introduced in the title of this kata. What's the use of saying "Eureka"? Because this sum gives the same number.

In effect: 89 = 8^1 + 9^2

The next number in having this property is 135.

See this property again: 135 = 1^1 + 3^2 + 5^3

We need a function to collect these numbers, that may receive two integers a, b that defines the range [a, b] (inclusive) and outputs a list of the sorted numbers in the range that fulfills the property described above.

Let's see some cases:

If there are no numbers of this kind in the range [a, b] the function should output an empty list.

Enjoy it!!

* */

public class SumDigPower {
    public static List<Long> sumDigPow(long a, long b) {
        // your code
        final List<Long> numbers = new ArrayList<>();
        for (long i = a; i <= b; ++i) {
            if (isSameNumber(i)) {
                numbers.add(i);
            }
        }
        return numbers;
    }

    private static boolean isSameNumber(long i) {
        return naiveCalculateSum(i) == i;
    }

    private static long naiveCalculateSum(long i) {
        final List<Long> digits = new ArrayList<>();
        while (i >= 10) {
            digits.add(i % 10);
            i /= 10;
        }
        digits.add(i % 10);

        long sum = 0;
        int pow = digits.size();
        for (Long digit : digits) {
            sum += pow(digit, pow);
            --pow;
        }
        return sum;
    }

    private static long pow(long a, int b) {
        if (b == 0) return 1;
        if (b == 1) return a;
        if (b % 2 == 0) return pow(a * a, b / 2); //even a=(a^2)^b/2
        else return a * pow(a * a, b / 2); //odd  a=a*(a^2)^b/2
    }
}
