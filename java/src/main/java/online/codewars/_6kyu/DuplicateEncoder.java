package online.codewars._6kyu;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

/**
 * Created by Hey on 13 Aug 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/duplicate-encoder/train/java
 */

/*

The goal of this exercise is to convert a string to a new string where each character in the new string is '(' if that character appears only once in the original string, or ')' if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate.

Examples:

"din" => "((("

"recede" => "()()()"

"Success" => ")())())"

"(( @" => "))(("

* */

@SuppressWarnings("WeakerAccess")
public class DuplicateEncoder {
    static String encode(String word) {
        word = word.toLowerCase();
        final Supplier<IntStream> streamSupplier = word::chars;
        final Set<Integer> charsAppearMoreThanOnce = streamSupplier.get().
                boxed().
                collect(groupingBy(Function.identity())).
                entrySet().
                stream().
                filter(e -> e.getValue().size() > 1).
                map(Map.Entry::getKey).
                collect(toSet());

        return streamSupplier.get().
                mapToObj(i -> charsAppearMoreThanOnce.contains(i) ? ")" : "(").
                collect(joining());
    }
}
