package online.codewars._6kyu;

import org.junit.Test;

import static online.codewars._6kyu.MultiTapKeypadTextEntryOnAnOldMobilePhone.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 18 Jun 2016
 */
public class MultiTapKeypadTextEntryOnAnOldMobilePhoneTest {
    @Test
    public void simpleTest() {
        assertEquals(9, Keypad.presses("LOL"));
        assertEquals(13, Keypad.presses("HOW R U"));

        assertEquals(47, Keypad.presses("WHERE DO U WANT 2 MEET L8R"));
        assertEquals(11, Keypad.presses("1abc2"));
        assertEquals(96, Keypad.presses("1abc2def3ghi4jkl5mno6pqrs7tuv8wxyz9* 0#"));
    }
}