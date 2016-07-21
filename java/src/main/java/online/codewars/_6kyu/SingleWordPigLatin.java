package online.codewars._6kyu;

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
//            for (int i = 0; i < str.length(); ++i) {
//                if (!isAlpha(str.charAt(i))) {
//                    return null;
//                }
//            }

            // case 5
            if (!(str.chars().allMatch(this::isAlpha))) {
                return null;
            }

            // case 5
            if ((str.chars().noneMatch(this::isVowel))) {
                return str + "ay";
            }


            final StringBuilder answer = new StringBuilder();
            str = str.toLowerCase();
//            if (str.isEmpty()){
//                return "ay";
//            }

            final char firstChar = str.charAt(0);
            if (isVowel(firstChar)) {
                return str + "way";
            }

            return answer.toString();
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

        private boolean isAlpha(int c) {
            return ((c >= 'A') && (c <= 'Z') && (c >= 'a') && (c <= 'z'));
        }

    }
}