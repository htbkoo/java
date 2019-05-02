package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TheCoinChangeProblem {
    public static class Solution {
        // Complete the getWays function below.
        static long getWays(long n, long[] c) {
            long[] ways = new long[(int) n + 1];
            IntStream.range(1, (int) n + 1).forEach(i -> {
                Arrays.stream(c).forEach(coin -> {
                    if (i > coin) {
                        ways[i] = Math.max(ways[i], 1 + ways[(int) (i - coin)]);
                    } else if (i == coin) {
                        ways[i] += 1;
//}else{

                    }
                });
            });

            return ways[(int) n];
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            long[] c = new long[m];

            String[] cItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m; i++) {
                long cItem = Long.parseLong(cItems[i]);
                c[i] = cItem;
            }

            // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

            long ways = getWays(n, c);

            bufferedWriter.close();

            scanner.close();
        }
    }
}
