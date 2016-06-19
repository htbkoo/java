package online.codewars._6kyu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hey on 19 Jun 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/80-s-kids-number-7-shes-a-small-wonder/train/java
 */

/*

Vicky is quite the small wonder. Most people don't even realize she's not a real girl, but a robot living amongst us. Sure, if you stick around her home for a while you might see her creator open up her back and make a few tweaks and even see her recharge in the closet instead of sleeping in a bed.

In this kata, we're going to help Vicky keep track of the words she's learning.

Write a function, learnWord(word) which is a method of the Robot object. The function should report back whether the word is now stored, or if she already knew the word.

Example:

Robot vicky = new Robot();
vicky.learnWord("hello") -> "Thank you for teaching me hello"
vicky.learnWord("abc") -> "Thank you for teaching me abc"
vicky.learnWord("hello") -> "I already know the word hello"
vicky.learnWord("wow!") -> "I do not understand the input"

Case shouldn't matter. Only alpha characters are valid. There's also a little trick here. Enjoy!
Check out my other 80's Kids Katas:
80's Kids #1: How Many Licks Does It Take
80's Kids #2: Help Alf Find His Spaceship
80's Kids #3: Punky Brewster's Socks
80's Kids #4: Legends of the Hidden Temple
80's Kids #5: You Can't Do That on Television
80's Kids #6: Rock 'Em, Sock 'Em Robots
80's Kids #7: She's a Small Wonder
80's Kids #8: The Secret World of Alex Mack
80's Kids #9: Down in Fraggle Rock
80's Kids #10: Captain Planet

* */

public class EightysKids7ShesASmallWonder {
    public static class Robot {
        // your code here
        private static final String INVALID = "I do not understand the input";
        private static final String TEACH = "Thank you for teaching me";
        private static final String KNOWN = "I already know the word";

        private final Set<String> vocab ;

        public Robot() {
            vocab = new HashSet<>();
            Arrays.stream(INVALID.split(" ")).map(String::toLowerCase).forEach(vocab::add);
            Arrays.stream(TEACH.split(" ")).map(String::toLowerCase).forEach(vocab::add);
            Arrays.stream(KNOWN.split(" ")).map(String::toLowerCase).forEach(vocab::add);
        }

        public String learnWord(String word) {
            if (word.isEmpty()){
                return INVALID;
            }

            String littleWord = word.toLowerCase();
            if (isValid(littleWord)) {
                if (vocab.contains(littleWord)) {
                    return getMessage(KNOWN, word);
                } else {
                    vocab.add(littleWord);
                    return getMessage(TEACH, word);
                }
            }
            return INVALID;
        }

        private boolean isValid(String littleWord) {
            return littleWord.chars().allMatch(i -> i >= 'a' && i <= 'z');
        }

        private String getMessage(String expression, String word) {
            return String.format("%s %s", expression, word);
        }
    }
}
