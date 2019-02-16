package online.hackerrank.interviewPreparationKit.Arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BalancedBrackets {
    public static class Solution {

        private static final String YES = "YES";
        private static final String NO = "NO";

        enum Bracket {
            CURLY_OPEN("{", "}", true), ROUND_OPEN("(", ")", true), SQUARE_OPEN("[", "]", true),
            CURLY_CLOSE("}", "{", false), ROUND_CLOSE(")", "(", false), SQUARE_CLOSE("]", "[", false);

            private final String ch;
            private final String corresponding;
            private final boolean isOpen;

            Bracket(String ch, String corresponding, boolean isOpen) {
                this.ch = ch;
                this.corresponding = corresponding;
                this.isOpen = isOpen;
            }

            static Bracket from(String ch) {
                return Arrays.stream(values())
                        .filter(bracket -> bracket.ch.equals(ch))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown character %s", ch)));
            }
        }

        // Complete the isBalanced function below.
        static String isBalanced(String s) {
            Deque<Bracket> opened = new ArrayDeque<>();
            final List<Bracket> brackets = Arrays.stream(s.split("")).map(Bracket::from).collect(Collectors.toList());

            for (Bracket b : brackets) {
                if (b.isOpen) {
                    opened.push(b);
                } else if (isInvalid(opened, b)) {
                    return NO;
                }
            }

            return opened.isEmpty() ? YES : NO;
        }

        private static boolean isInvalid(Deque<Bracket> brackets, Bracket closeBracket) {
            return brackets.isEmpty() || !closeBracket.corresponding.equals(brackets.pop().ch);
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                String s = scanner.nextLine();

                String result = isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            scanner.close();
        }
    }
}
