package online.codewars._6kyu;

import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * Created by Hey on 21 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/single-word-pig-latin/train/java
 */

/*

Pig Latin is an English language game where the goal is to hide the meaning of a word from people not aware of the rules.

The rules themselves are rather easy:

1) The word starts with a vowel(a,e,i,o,u) -> return the original string plus "way".

2) The word starts with a consonant -> move consonants from the beginning of the word to the end of the word until the first vowel, then return it plus "ay".

3) The result must be lowercase, regardless of the case of the input. If the input string has any non-alpha characters, the function must return None, null, Nothing (depending on the language).

4) The function must also handle simple random strings and not just English words.

5) The input string has no vowels -> return the original string plus "ay".

For example, the word "spaghetti" becomes "aghettispay" because the first two letters ("sp") are consonants, so they are moved to the end of the string and "ay" is appended.

* */

@SuppressWarnings("WeakerAccess")
public class SingleWordPigLatin {
    public static class PigLatin {

        public String translate(String str) {
            //good code
            // case 3
            final Supplier<IntStream> streamSupplier = str::chars;
            if (!(streamSupplier.get().allMatch(this::isAlpha))) {
                return null;
            }

            str = str.toLowerCase();

            // case 5
            if ((streamSupplier.get().noneMatch(this::isVowel))) {
                return str + "ay";
            }

            final StringBuilder answer = new StringBuilder();

            // case 1
            final char firstChar = str.charAt(0);
            if (isVowel(firstChar)) {
                return str + "way";
            } else {
//                case 2
                int index = 0;
                final int strLen = str.length();
                while (!isVowel(str.charAt(index)) && index < strLen) {
                    answer.append(str.charAt(index));
                    ++index;
                }
                return str.substring(index) + answer.toString() + "ay";
            }
        }

        private boolean isVowel(int c) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    return true;
                default:
                    return false;
            }
        }

        public boolean isAlpha(int c) {
            return ((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z'));
        }

    }
}