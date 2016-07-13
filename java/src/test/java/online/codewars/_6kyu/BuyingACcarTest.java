package online.codewars._6kyu;

import org.junit.Test;

import static online.codewars._6kyu.BuyingACcar.*;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Hey on 12 Jul 2016
 */
public class BuyingACcarTest {

    @Test
    public void test1() {
        int[] r = new int[]{6, 766};
        assertArrayEquals(r, BuyCar.nbMonths(2000, 8000, 1000, 1.5));
    }

    @Test
    public void test2() {
        int[] r = new int[]{0, 4000};
        assertArrayEquals(r, BuyCar.nbMonths(12000, 8000, 1000, 1.5));
    }
}