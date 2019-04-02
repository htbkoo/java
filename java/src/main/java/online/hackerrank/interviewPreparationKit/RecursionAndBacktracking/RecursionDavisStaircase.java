package online.hackerrank.interviewPreparationKit.RecursionAndBacktracking;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RecursionDavisStaircase {
    public static class Solution {
        private static final int MODULUS = 1_000_000_007;

        // Complete the stepPerms function below.
        static int stepPerms(int n) {
            if (n <= 0) {
                throw new IllegalArgumentException("expected n to be positive, but was: " + n);
            } else if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            } else {
                int current = 4, minus1 = 2, minus2 = 1;
                while (n > 3) {
                    n--;
                    int temp = current;
                    current = sum(current, minus1, minus2);
                    minus2 = minus1;
                    minus1 = temp;
                }
                return current;
            }
        }

        private static int sum(int... num) {
//            return Arrays.stream(num).reduce(0, (i, j) -> (i + j) % MODULUS);
            // yes, thanks to the misleading and wrong problem description
            // reference: https://www.hackerrank.com/challenges/ctci-recursive-staircase/forum/comments/467990
            return Arrays.stream(num).sum();
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int sItr = 0; sItr < s; sItr++) {
                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int res = stepPerms(n);

                bufferedWriter.write(String.valueOf(res));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            scanner.close();
        }
    }
}
