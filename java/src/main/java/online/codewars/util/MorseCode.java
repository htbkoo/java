package online.codewars.util;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Created by Hey on 11 May 2016.
 *
 * ---
 *
 * Util for DecodeTheMorseCode
 */
public final class MorseCode {
    private static final Map<String, Character> MORSE_DICT =
            ImmutableMap.<String, Character>builder()
                    .put(".-", 'A')
                    .put("-...", 'B')
                    .put("-.-.", 'C')
                    .put("-..", 'D')
                    .put(".", 'E')
                    .put("..-.", 'F')
                    .put("--.", 'G')
                    .put("....", 'H')
                    .put("..", 'I')
                    .put(".---", 'J')
                    .put("-.-", 'K')
                    .put(".-..", 'L')
                    .put("--", 'M')
                    .put("-.", 'N')
                    .put("---", 'O')
                    .put(".--.", 'P')
                    .put("--.-", 'Q')
                    .put(".-.", 'R')
                    .put("...", 'S')
                    .put("-", 'T')
                    .put("..-", 'U')
                    .put("...-", 'V')
                    .put(".--", 'W')
                    .put("-..-", 'X')
                    .put("-.--", 'Y')
                    .put("--..", 'Z')
                    .put("-----", '0')
                    .put(".----", '1')
                    .put("..---", '2')
                    .put("...--", '3')
                    .put("....-", '4')
                    .put(".....", '5')
                    .put("-....", '6')
                    .put("--...", '7')
                    .put("---..", '8')
                    .put("----.", '9')
                    .put(".-.-", 'Ä')
                    .put(".--.-", 'Á')
                    .put("..-..", 'É')
                    .put("--.--", 'Ñ')
                    .put("---.", 'Ö')
                    .put("..--", 'Ü')
                    .put(".-.-.-", '.')
                    .put("--..--", ',')
                    .put("---...", ':')
                    .put("..--..", '?')
                    .put(".----.", ';')
                    .put("-....-", '-')
                    .put("-..-.", '/')
                    .put(".-..-.", '\'')
                    .put(".--.-.", '@')
                    .put("-...-", '=')
                    .build();


    public static char get(String str) {
        if (!MORSE_DICT.containsKey(str)) {
            throw new IllegalArgumentException(String.format("String %s not found in the morse dictionary!", str));
        }
        return MORSE_DICT.get(str);
    }
}
