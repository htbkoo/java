package online.codewars._6kyu;

import org.junit.Test;

import static online.codewars._6kyu.CreatePhoneNumber.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 16 Jul 2016
 */
public class CreatePhoneNumberTest {
    @Test
    public void tests() {
        assertEquals("(123) 456-7890", Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}