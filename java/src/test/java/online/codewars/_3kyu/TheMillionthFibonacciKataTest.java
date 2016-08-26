package online.codewars._3kyu;

import online.codewars._3kyu.TheMillionthFibonacciKata.Fibonacci;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 24 Aug 2016
 */
@RunWith(Parameterized.class)
public class TheMillionthFibonacciKataTest {
    private final BigInteger expected, input;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{new BigInteger("0"), new BigInteger("0")},
                new Object[]{new BigInteger("1"), new BigInteger("1")},
                new Object[]{new BigInteger("2"), new BigInteger("1")},
                new Object[]{new BigInteger("3"), new BigInteger("2")},
                new Object[]{new BigInteger("4"), new BigInteger("3")},
                new Object[]{new BigInteger("5"), new BigInteger("5")},
                new Object[]{new BigInteger("-1"), new BigInteger("1")},
                new Object[]{new BigInteger("-2"), new BigInteger("-1")},
                new Object[]{new BigInteger("-3"), new BigInteger("2")},
                new Object[]{new BigInteger("-4"), new BigInteger("-3")},
                new Object[]{new BigInteger("-5"), new BigInteger("5")},
                new Object[]{new BigInteger("-6"), new BigInteger("-8")}
        );
    }

    @Test
    public void testFib() throws Exception {
        testFib(expected, input);
    }

    public TheMillionthFibonacciKataTest(BigInteger input, BigInteger expected) {
        this.input = input;
        this.expected = expected;
    }

    @Ignore
    @Test
    public void testFib0() {
        testFib(0, 0);
    }

    @Ignore
    @Test
    public void testFib1() {
        testFib(1, 1);
    }

    @Ignore
    @Test
    public void testFib2() {
        testFib(1, 2);
    }

    @Ignore
    @Test
    public void testFib3() {
        testFib(2, 3);
    }

    @Ignore
    @Test
    public void testFib4() {
        testFib(3, 4);
    }

    @Ignore
    @Test
    public void testFib5() {
        testFib(5, 5);
    }

    private static void testFib(long expected, long input) {
        BigInteger found;
        try {
            found = Fibonacci.fib(BigInteger.valueOf(input));
        } catch (Throwable e) {
            // see https://github.com/Codewars/codewars.com/issues/21
            throw new AssertionError("exception during test: " + e, e);
        }
        assertEquals(BigInteger.valueOf(expected), found);
    }

    private static void testFib(BigInteger expected, BigInteger input) {
        BigInteger found;
        try {
            found = Fibonacci.fib(input);
        } catch (Throwable e) {
            // see https://github.com/Codewars/codewars.com/issues/21
            throw new AssertionError("exception during test: " + e, e);
        }
        assertEquals(expected, found);
    }

}