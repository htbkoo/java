package online.atCoder.beginnerContext118;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class MatchMatching {
    private static final Map<Integer, Integer> MAPPING = buildMapping();

    private static Map<Integer, Integer> buildMapping() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 5);
        map.put(3, 5);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 3);
        map.put(8, 7);
        map.put(9, 6);
        return map;
    }

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        String number = findLargestNumber(testCase);

        output(number);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int M = sc.nextInt();

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < M; ++i) {
            int AN = sc.nextInt();
            A.add(AN);
        }

        sc.close();

        return new TestCase(N, A);
    }

    private static final Optional<String> NO_ANSWER = Optional.empty();

    public static String findLargestNumber(TestCase testCase) {
        final int N = testCase.N;
        final List<Integer> A = testCase.A;
        List<Optional<String>> answers = new ArrayList<>();
        answers.add(0, NO_ANSWER);

        for (int i = 1; i <= N; ++i) {
            final int iFinal = i; // to circumvent the stream limitation in Java
            answers.add(
                    i,
                    A.stream()
                            .map(digit -> {
                                final Integer numMatchesNeeded = MAPPING.get(digit);
                                if (isOneMoreDigitPossible(answers, iFinal, numMatchesNeeded)) {
                                    return Optional.of(oneMoreDigit(answerWithoutDigit(answers, iFinal, numMatchesNeeded).get(), digit));
                                } else if (iFinal == numMatchesNeeded) {
                                    return Optional.of(digit.toString());
                                } else {
                                    return NO_ANSWER;
                                }
                            })
                            .filter(Optional::isPresent)
                            .map(Optional::get)
                            .max(Comparator.comparing(BigInteger::new))
            );
        }

        return answers.get(N).orElseThrow(() -> new IllegalStateException("No solution for " + N));
    }

    private static boolean isOneMoreDigitPossible(List<Optional<String>> answers, int iFinal, Integer numMatchesNeeded) {
        final boolean hasEnoughMatches = iFinal > numMatchesNeeded;
        if (hasEnoughMatches) {
            return answerWithoutDigit(answers, iFinal, numMatchesNeeded).isPresent();
        } else {
            return false;
        }
    }

    private static Optional<String> answerWithoutDigit(List<Optional<String>> answers, int iFinal, Integer numMatchesNeeded) {
        return answers.get(iFinal - numMatchesNeeded);
    }

    private static String oneMoreDigit(String answerWithoutDigit, Integer digit) {
        if (Character.getNumericValue(answerWithoutDigit.charAt(0)) <= digit) {
            return digit.toString() + answerWithoutDigit;
        }

        for (int i = 0, length = answerWithoutDigit.length(); i < length; ++i) {
            if (Character.getNumericValue(answerWithoutDigit.charAt(i)) <= digit) {
                return answerWithoutDigit.substring(0, i) + digit.toString() + answerWithoutDigit.substring(i, length);
            }
        }
        return answerWithoutDigit + digit.toString();
    }

    private static void output(String str) {
        System.out.println(str);
    }

    public static class TestCase {
        final int N;
        final List<Integer> A;

        public TestCase(int N, List<Integer> A) {
            this.N = N;
            this.A = A;
        }
    }

}
