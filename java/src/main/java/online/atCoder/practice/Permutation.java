package online.atCoder.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

public class Permutation {
    private static final int CHAR_CODE_A = 65;

    public static List<String> generatePermutation(int n) {
        return permutation(
                new StringBuilder(),
                IntStream.range(0, n)
                        .map(it -> CHAR_CODE_A + it)
                        .boxed()
                        .map(Character::toChars)
                        .map(String::new)
                        .collect(toList())
        );
    }

    private static List<String> permutation(StringBuilder builder, List<String> candidates) {
        if (candidates.size() <= 0) {
            return emptyList();
        } else if (candidates.size() == 1) {
            return singletonList(builder + candidates.get(0));
        } else {
            return candidates.stream()
                    .flatMap(withOneMoreLetter(builder, candidates))
                    .collect(Collectors.toList());
        }
    }

    private static Function<String, Stream<String>> withOneMoreLetter(StringBuilder builder, List<String> candidates) {
        return candidate -> {
            final StringBuilder newBuilder = new StringBuilder(builder).append(candidate);
            final ArrayList<String> newCandidates = new ArrayList<>(candidates);
            newCandidates.remove(candidate);
            return permutation(newBuilder, newCandidates).stream();
        };
    }
}
