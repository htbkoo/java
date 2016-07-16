package online.codewars._6kyu;

import java.util.Arrays;

/**
 * Created by Hey on 16 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/create-phone-number/train/java
 */

/*

Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.

Example:

Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"

The returned format must be correct in order to complete this challenge.
Don't forget the space after the closing parenthese!

* */

@SuppressWarnings("WeakerAccess")
public class CreatePhoneNumber {

//    format: (123) 456-7890

    public static class Kata {
        public static String createPhoneNumber(int[] numbers) {
            // Your code here!
            return String.format(
                    "(%d%d%d) %d%d%d-%d%d%d%d",
                    Arrays.stream(numbers).boxed().toArray()
            );
        }
    }
}