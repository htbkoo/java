package online.codewars._6kyu;

import org.junit.Test;

import static online.codewars._6kyu.StopGninnipSMySdroW.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 22 Jul 2016
 */
public class StopGninnipSMySdroWTest {
    @Test
    public void test() {
        assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));
    }
}