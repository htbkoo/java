package online.codewars._6kyu;

import online.codewars._6kyu.ReachMeAndSumMyDigits.SumDigNth;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 27 Jul 2016
 */
public class ReachMeAndSumMyDigitsTest {

    private static void testing(long act, long exp) {
        assertEquals(exp, act);
    }

    @Test
    public void test1() {
        System.out.println("Basic Tests **** sumDigNthTerm");
        testing(SumDigNth.sumDigNthTerm(10, new long[]{2, 1, 3}, 6), 10);
        testing(SumDigNth.sumDigNthTerm(10, new long[]{2, 1, 3}, 15), 10);
        testing(SumDigNth.sumDigNthTerm(10, new long[]{2, 1, 3}, 50), 9);
        testing(SumDigNth.sumDigNthTerm(10, new long[]{2, 1, 3}, 78), 10);
        testing(SumDigNth.sumDigNthTerm(10, new long[]{2, 1, 3}, 157), 7);
    }
}