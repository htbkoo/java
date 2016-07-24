package online.codewars._6kyu;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Hey on 21 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/stop-gninnips-my-sdrow/train/java
 */

/*

Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.

Examples:

spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
spinWords( "This is a test") => returns "This is a test"
spinWords( "This is another test" )=> returns "This is rehtona test"

* */

@SuppressWarnings("WeakerAccess")
public class StopGninnipSMySdroW {
    public static class SpinWords {

        public String spinWords(String sentence) {
            //Done: Code stuff here
            return Arrays.
                    stream(sentence.split(" ")).
                    map(s -> s.length() >= 5 ? new StringBuilder(s).reverse().toString() : s).
                    collect(Collectors.joining(" "));
        }
    }
}