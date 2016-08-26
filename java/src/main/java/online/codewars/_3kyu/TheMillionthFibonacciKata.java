package online.codewars._3kyu;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * Created by Hey on 24 Aug 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/the-millionth-fibonacci-kata/train/java
 */

/*

The year is 1214. One night, Pope Innocent III awakens to find the the archangel Gabriel floating before him. Gabriel thunders to the pope:

    Gather all of the learned men in Pisa, especially Leonardo Fibonacci. In order for the crusades in the holy lands to be successful, these men must calculate the millionth number in Fibonacci's recurrence. Fail to do this, and your armies will never reclaim the holy land. It is His will.

The angel then vanishes in an explosion of white light.

Pope Innocent III sits in his bed in awe. How much is a million? he thinks to himself. He never was very good at math.

He tries writing the number down, but because everyone in Europe is still using Roman numerals at this moment in history, he cannot represent this number. If he only knew about the invention of zero, it might make this sort of thing easier.

He decides to go back to bed. He consoles himself, The Lord would never challenge me thus; this must have been some deceit by the devil. A pretty horrendous nightmare, to be sure.

Pope Innocent III's armies would go on to conquer Constantinople (now Istanbul), but they would never reclaim the holy land as he desired.

In this kata you will have to calculate fib(n) where:

fib(0) := 0
fib(1) := 1
fin(n + 2) := fib(n + 1) + fib(n)

Write an algorithm that can handle n where 1000000 ≤ n ≤ 1500000.

Your algorithm must output the exact integer answer, to full precision. Also, it must correctly handle negative numbers as input.

HINT I: Can you rearrange the equation fib(n + 2) = fib(n + 1) + fib(n) to find fib(n) if you already know fin(n + 1) and fib(n + 2)? Use this to reason what value fib has to have for negative values.

HINT II: See http://mitpress.mit.edu/sicp/chapter1/node15.html

* */

@SuppressWarnings("WeakerAccess")
public class TheMillionthFibonacciKata {
    public static class Fibonacci {
        public static BigInteger fib(BigInteger n) {
            // ...
            BigInteger fib0 = ZERO;
            BigInteger fib1 = ONE;
            final BigInteger TWO = BigInteger.valueOf(2L);
            final Deque<Boolean> stack = new ArrayDeque<>();

            if (n.equals(ZERO)) {
                return fib0;
            } else if (n.equals(ONE)) {
                return fib1;
            } else if (n.compareTo(ZERO) > 0) {
                // Dynamic Programming - O(n) still too slow.......
                if (n.compareTo(BigInteger.valueOf(1000L)) <= 0) {
                    while (n.compareTo(BigInteger.ONE) > 0) {
                        BigInteger temp = fib0.add(fib1);
                        fib0 = fib1;
                        fib1 = temp;
                        n = n.subtract(BigInteger.ONE);
                    }
                    return fib1;
                }

                // From https://www.nayuki.io/page/fast-fibonacci-algorithms
                // Fast doubling (faster)
                // Given F(k) and F(k+1), we can calculate these:
                // F(2k)=F(k)[2F(k+1)−F(k)]; F(2k+1)=F(k+1)^2+F(k)^2
                fib1 = TWO; // now f(3)
                fib0 = ONE; // now f(2)
                if (n.equals(TWO)) {
                    return fib0;
                }
                if (n.equals(BigInteger.valueOf(3))) {
                    return fib1;
                }
                while (n.compareTo(TWO) > 0) {
                    final boolean isEven = n.mod(TWO).equals(ZERO);
                    stack.push(isEven);
                    if (isEven) {
                        n = n.divide(TWO);
                    } else {
                        n = n.subtract(ONE);
                    }
                }

                while (!stack.isEmpty()) {
                    if (stack.pop()) {
                        BigInteger f2k0 = fib0.multiply(fib1.multiply(TWO).subtract(fib0)); // f(2k)
                        fib1 = fib1.multiply(fib1).add(fib0.multiply(fib0)); // f(2k+1)
                        fib0 = f2k0;
                    } else {
                        BigInteger fib2 = fib1.add(fib0);
                        fib0 = fib1;
                        fib1 = fib2;
                    }
                }
                return fib0;
            } else {
                while (n.compareTo(ONE.negate()) <= 0) {
                    BigInteger temp = fib1.subtract(fib0);
                    fib1 = fib0;
                    fib0 = temp;
                    n = n.add(ONE);
                }
                return fib0;
            }
        }
    }
}
