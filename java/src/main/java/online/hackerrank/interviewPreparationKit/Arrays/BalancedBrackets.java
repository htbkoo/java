package online.hackerrank.interviewPreparationKit.Arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedBrackets {
    public static class Solution {

        private static final String YES = "YES";
        private static final String NO = "NO";

        // Complete the isBalanced function below.
        static String isBalanced(String s) {
            Deque<String> brackets = new ArrayDeque<>();

            final String[] chars = s.split("");
            for (String ch : chars) {
                switch (ch) {
                    case "{":
                    case "(":
                    case "[": {
                        brackets.push(ch);
                        break;
                    }
                    case ("}"): {
                        if (isInvalid(brackets, "{")){
                            return NO;
                        }
                        break;
                    }
                    case (")"): {
                        if (isInvalid(brackets, "(")){
                            return NO;
                        }
                        break;
                    }
                    case ("]"): {
                        if (isInvalid(brackets, "[")){
                            return NO;
                        }
                        break;
                    }
                }
            }

            return brackets.isEmpty() ? YES : NO;
        }

        private static boolean isInvalid(Deque<String> brackets, String corresponding) {
            return brackets.isEmpty() || !corresponding.equals(brackets.pop());
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
