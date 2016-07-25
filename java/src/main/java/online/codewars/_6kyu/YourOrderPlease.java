package online.codewars._6kyu;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Hey on 25 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/your-order-please/train/java
 */

/*

Your task is to sort a given string. Each word in the String will contain a single number. This number is the position the word should have in the result.

Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

If the input String is empty, return an empty String. The words in the input String will only contain valid consecutive numbers.

For an input: "is2 Thi1s T4est 3a" the function should return "Thi1s is2 3a T4est"

* */

@SuppressWarnings("WeakerAccess")
public class YourOrderPlease {
    public static class Order {
        public static String order(String words) {
            // ...
            if (words.isEmpty()) {
                return "";
            }

            Function<String, String> getNumber = s -> s.
                    chars().
                    filter(c -> (c >= '0') && (c <= '9')).
                    mapToObj(i -> String.valueOf((char) i)).
                    collect(Collectors.joining());

            return Arrays.stream(words.split(" ")).
                    sorted((s1, s2) -> getNumber.apply(s1).compareTo(getNumber.apply(s2))).
                    collect(Collectors.joining(" "));
        }
    }
}