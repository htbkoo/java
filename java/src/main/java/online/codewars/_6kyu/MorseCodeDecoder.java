package online.codewars._6kyu;

import online.codewars.util.MorseCode;

/**
 * Created by Hey on 11 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/decode-the-morse-code/train/java
 */
public class MorseCodeDecoder {
    //    public class DecodeTheMorseCode {
    //    }

    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
        morseCode = morseCode.trim().replaceAll("  ", " ");
        final String[] words = morseCode.split(" ", -1);

        final StringBuilder decoded = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                decoded.append(MorseCode.get(word));
            } else {
                decoded.append(" ");
            }
        }
        return decoded.toString();
    }


    /*
     for (String word : words) {
            if (!word.isEmpty()) {
                final char firstChar = word.charAt(0);
                if ((firstChar != '.') && (firstChar != '-')) {
                    decoded.append(" ");
                }
                decoded.append(MorseCode.get(word));
            }
        }
    *
    * */
}
