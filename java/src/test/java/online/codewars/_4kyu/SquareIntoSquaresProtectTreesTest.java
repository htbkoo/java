package online.codewars._4kyu;

import org.junit.Test;

import static online.codewars._4kyu.SquareIntoSquaresProtectTrees.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 29 May 2016
 */
public class SquareIntoSquaresProtectTreesTest {
    private Decompose d = new Decompose();

    @Test
    public void test1() {
        assertDecompose(11, "1 2 4 10");
    }

    @Test
    public void shouldDecompose50() {
        assertDecompose(50, "1 3 5 8 49");
    }

    @Test
    public void shouldNotBeAbleToDecompose4() {
        assertDecompose(4, "");
    }

    private void assertDecompose(long n, String expected) {
        assertEquals(expected, d.decompose(n));
    }
}