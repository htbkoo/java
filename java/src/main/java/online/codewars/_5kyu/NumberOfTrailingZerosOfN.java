package online.codewars._5kyu;

/**
 * Created by Hey on 15 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/number-of-trailing-zeros-of-n/train/java
 */

/*

Write a program that will calculate the number of trailing zeros in a factorial of a given number.

N! = 1 * 2 * 3 * 4 ... N

zeros(12) = 2 # 1 * 2 * 3 .. 12 = 479001600
that has 2 trailing zeros 4790016(00)

Be careful 1000! has length of 2568 digital numbers.

* */

public class NumberOfTrailingZerosOfN {
    public static int zeros(int n) {
        // your beatiful code here
        int sum = 0;
        long cur = 5;
        while (cur <= n) {
            sum += n / cur;
            cur *= 5;
        }
        return sum;
    }
}
