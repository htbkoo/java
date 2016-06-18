package online.codewars._6kyu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by Hey on 18 Jun 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/multi-tap-keypad-text-entry-on-an-old-mobile-phone/train/java
 */

/*

Prior to having fancy iPhones, teenagers would wear out their thumbs sending SMS messages on candybar-shaped feature phones with 3x4 numeric keypads.

------- ------- -------
|     | | ABC | | DEF |
|  1  | |  2  | |  3  |
------- ------- -------
------- ------- -------
| GHI | | JKL | | MNO |
|  4  | |  5  | |  6  |
------- ------- -------
------- ------- -------
|PQRS | | TUV | | WXYZ|
|  7  | |  8  | |  9  |
------- ------- -------
------- ------- -------
|     | |space| |     |
|  *  | |  0  | |  #  |
------- ------- -------

Prior to the development of T9 (predictive text entry) systems, the method to type words was called "multi-tap" and involved pressing a button repeatedly to cycle through the possible values.

For example, to type a letter "R" you would press the 7 key three times (as the screen display for the current character cycles through P->Q->R->S->7). A character is "locked in" once the user presses a different key or pauses for a short period of time (thus, no extra button presses are required beyond what is needed for each letter individually). The zero key handles spaces, with one press of the key producing a space and two presses producing a zero.

In order to send the message "WHERE DO U WANT 2 MEET L8R" a teen would have to actually do 47 button presses. No wonder they abbreviated.

For this assignment, write a module that can calculate the amount of button presses required for any phrase. Punctuation can be ignored for this exercise. Likewise, you can assume the phone doesn't distinguish between upper/lowercase characters (but you should allow your module to accept input in either for convenience).

Hint: While it wouldn't take too long to hard code the amount of keypresses for all 26 letters by hand, try to avoid doing so! (Imagine you work at a phone manufacturer who might be testing out different keyboard layouts, and you want to be able to test new ones rapidly.)

* */

public class MultiTapKeypadTextEntryOnAnOldMobilePhone {
    public static class Keypad {
        private static final List<String> KEY_CONFIG = Arrays.asList(
                "1",
                "ABC2",
                "DEF3",
                "GHI4",
                "JKL5",
                "MNO6",
                "PQRS7",
                "TUV8",
                "WXYZ9",
                "*",
                " 0",
                "#"
        );

//        private static final Map<Character, Integer> KEYPRESSES = new HashMap<Character, Integer>() {{
//        }};
//        DoubleBraceInitialization, may not be the best practice
//        Yet another ugly hackish way - due to the fact that chars() is an IntStream instead of a CharStream, thus using Integer as Key
        private static final Map<Integer, Integer> KEYPRESSES = new HashMap<Integer, Integer>() {{
            KEY_CONFIG.stream().forEach(
                    s -> IntStream.range(0, s.length()).forEach(
                            index -> put((int) s.charAt(index), index+1)
                    ));
        }};

        public static int presses(String phrase) {
            // To account for anything that might not have been metioned in the instruction
            // return phrase.toUpperCase().chars().map(KEYPRESSES::get).sum();
            return phrase.toUpperCase().chars().map(i->{
                if (KEYPRESSES.containsKey(i)){
                    return KEYPRESSES.get(i);
                }
                return 0;
            }).sum();
        }
    }

}
