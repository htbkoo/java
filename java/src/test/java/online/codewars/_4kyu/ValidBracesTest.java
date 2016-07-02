package online.codewars._4kyu;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static online.codewars._4kyu.ValidBraces.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 2 Jul 2016
 */
public class ValidBracesTest {

    private BraceChecker checker = new BraceChecker();

    @Test
    public void testValid() {
        assertEquals(true, checker.isValid("()"));
    }

    @Test
    public void testInvalid() {
        assertEquals(false, checker.isValid("[(])"));
    }

    @Test
    public void testValidDuringSubmit() {
        assertTrue(checker.isValid("()"));
        assertTrue(checker.isValid("[]"));
        assertTrue(checker.isValid("{}"));
        assertTrue(checker.isValid("(){}[]"));
        assertTrue(checker.isValid("([{}])"));
        assertTrue(checker.isValid("({})[({})]"));
        assertTrue(checker.isValid("(({{[[]]}}))"));
        assertTrue(checker.isValid("{}({})[]"));
    }

    @Test
    public void testInValidDuringSubmit() {
        assertFalse(checker.isValid("[(])"));
        assertFalse(checker.isValid("(}"));
        assertFalse(checker.isValid("(})"));
        assertFalse(checker.isValid(")(}{]["));
        assertFalse(checker.isValid("())({}}{()][]["));
        assertFalse(checker.isValid("(((({{"));
    }

    @Test
    public void testEmpty() {
        assertEquals(true, checker.isValid(""));
    }

}