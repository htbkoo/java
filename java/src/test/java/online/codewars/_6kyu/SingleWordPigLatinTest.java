package online.codewars._6kyu;

import org.junit.Before;
import org.junit.Test;

import static online.codewars._6kyu.SingleWordPigLatin.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 21 Jul 2016
 */
public class SingleWordPigLatinTest {

    private PigLatin p;

    @Before
    public void setUp() throws Exception {
        p = new PigLatin();

    }

    @Test
    public void testMap() {
        assertEquals("apmay", p.translate("map"));
    }

    @Test
    public void testegg() {
        assertEquals("eggway", p.translate("egg"));
    }

    @Test
    public void testspaghetti() {
        assertEquals("aghettispay", p.translate("spaghetti"));
    }

    /*

  expected:<[cccc]ay> but was:<[CCCC]ay>

 testXYZE(TestPigLatin)

  expected:<[exyz]ay> but was:<[XYZE]ay>

 testYA(TestPigLatin)

  expected:<[ay]ay> but was:<[YA]ay>

    * */

}