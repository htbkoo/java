package online.codewars._6kyu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static online.codewars._6kyu.EightysKids7ShesASmallWonder.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 19 Jun 2016
 */
public class EightysKids7ShesASmallWonderTest {
    private Robot vicky;

    @Before
    public void setUp() {
        vicky = new Robot();
    }

    @After
    public void tearDown() {
        vicky = null;
    }

    @Test
    public void simpleTest() {
        assertEquals("Thank you for teaching me hello", vicky.learnWord("hello"));
        assertEquals("Thank you for teaching me world", vicky.learnWord("world"));
        assertEquals("Thank you for teaching me goodbye", vicky.learnWord("goodbye"));
        assertEquals("I already know the word world", vicky.learnWord("world"));
        assertEquals("I already know the word World", vicky.learnWord("World"));
    }
}