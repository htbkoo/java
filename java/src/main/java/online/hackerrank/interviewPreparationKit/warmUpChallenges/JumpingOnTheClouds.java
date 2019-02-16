package online.hackerrank.interviewPreparationKit.warmUpChallenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheClouds {
    public static class Solution {
        // Complete the jumpingOnClouds function below.
        static int jumpingOnClouds(int[] c) {
            final int IMPOSSIBLE = Integer.MAX_VALUE;

            final int n = c.length;
            int[] jumps = new int[n];

            jumps[0] = 0;
            jumps[1] = isThunderhead(c[1]) ? IMPOSSIBLE : 1;

            for (int i = 2; i < n; ++i) {
                if (isThunderhead(c[i])) {
                    jumps[i] = IMPOSSIBLE;
                } else {
                    jumps[i] = 1 + Math.min(jumps[i - 1], jumps[i - 2]);
                }
            }

            return jumps[n - 1];
        }

        private static boolean isThunderhead(int c) {
            return c == 1;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] c = new int[n];

            String[] cItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }

            int result = jumpingOnClouds(c);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
