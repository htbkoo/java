package online.codewars._4kyu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hey on 28 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/square-into-squares-protect-trees/train/java
 */

/*

My little sister came back home from school with the following task: given a squared sheet of paper she has to cut it in pieces which, when assembled, give squares the sides of which form an increasing sequence of numbers. At the beginning it was lot of fun but little by little we were tired of seeing the pile of torn paper. So we decided to write a program that could help us and protects trees.
Task

Given a positive integral number n, return a strictly increasing sequence (list/array/string depending on the language) of numbers, so that the sum of the squares is equal to n².

If there are multiple solutions (and there will be), return the result with the largest possible values:
Examples

decompose(11) must return [1,2,4,10]. Note that there are actually two ways to decompose 11², 11² = 121 = 1 + 4 + 16 + 100 = 1² + 2² + 4² + 10² but don't return [2,6,9], since 9 is smaller than 10.

For decompose(50) don't return [1, 1, 4, 9, 49] but [1, 3, 5, 8, 49] since [1, 1, 4, 9, 49] doesn't form a strictly increasing sequence.

decompose 50 `shouldBe` Just [1,3,5,8,49]
decompose 4  `shouldBe` Nothing

Note

Neither [n] nor [1,1,1,…,1] are valid solutions. If no valid solution exists, return nil, null, Nothing, None or "".

The function "decompose" will take a positive integer n and return the decomposition of N = n² as:

"x1 ... xk"

Hint

Very often xk will be n-1.

* */

public class SquareIntoSquaresProtectTrees {
    public static class Decompose {

        public String decompose(long n) {
            final long nSquare = n * n;
            for (long i = n - 1; i > 0; --i) {
                final long remainValue = nSquare - i * i;
                long maxPossible = (long) Math.sqrt(remainValue);
                final String answer = recursion(remainValue, maxPossible, String.valueOf(i));
                if (!("".equals(answer))) {
                    return answer;
                }
            }
            return "";
        }

        private String recursion(long remainValue, long cur, String answer) {
            if (cur <= 0) {
                return "";
            }
            final long curSquare = cur * cur;
            final String answerIfInclude = "".equals(answer) ? String.valueOf(cur) : String.format("%d %s", cur, answer);
            if (remainValue == curSquare) {
                return answerIfInclude;
            } else if (remainValue < curSquare) {
                return recursion(remainValue, cur - 1, answer);
            } else {
                final String finalAnswer = recursion(remainValue - curSquare, cur - 1, answerIfInclude);
                if ("".equals(finalAnswer)) {
                    return recursion(remainValue, cur - 1, answer);
                } else {
                    return finalAnswer;
                }
            }
        }

        private static class AttemptedDPApproach {
            public String decompose(long n) {
                final List<Long> squares = new ArrayList<>();
                squares.add(0L);
                for (long i = 1; i <= n; ++i) {
                    squares.add(i * i);
                }
                return "";
            }
        }

        private static class NaiveExhaustiveApproach {
            public String decompose(long n) {
                return recursion(n * n, n - 1, "");
            }

            private String recursion(long remainValue, long cur, String answer) {
                if (cur <= 0) {
                    return "";
                }
                final long curSquare = cur * cur;
                final String answerIfInclude = "".equals(answer) ? String.valueOf(cur) : String.format("%d %s", cur, answer);
                if (remainValue == curSquare) {
                    return answerIfInclude;
                } else if (remainValue < curSquare) {
                    return recursion(remainValue, cur - 1, answer);
                } else {
                    final String finalAnswer = recursion(remainValue - curSquare, cur - 1, answerIfInclude);
                    if ("".equals(finalAnswer)) {
                        return recursion(remainValue, cur - 1, answer);
                    } else {
                        return finalAnswer;
                    }
                }
            }
        }
    }
}
