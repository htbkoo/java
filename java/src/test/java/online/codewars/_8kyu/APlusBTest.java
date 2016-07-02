package online.codewars._8kyu;

import org.junit.Test;

import static online.codewars._8kyu.APlusB.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 2 Jul 2016
 */
public class APlusBTest {
    @Test
    public void testSum() throws Exception {
        byte a = 1;
        byte b = 2;
        assertEquals(3, FirstClass.sum(a, b));
    }
}