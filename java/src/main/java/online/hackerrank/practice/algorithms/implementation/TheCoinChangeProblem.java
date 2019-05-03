package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.util.stream.IntStream.range;

public class TheCoinChangeProblem {
    public static class Solution {
        // Complete the getWays function below.
        static long getWays(long n, long[] c) {
            int nInt = (int) n;
            int numCoins = c.length;

            long[][] ways = new long[nInt + 1][numCoins + 1];
            range(0, numCoins + 1).forEach(i -> ways[0][i] = 1); // always have 1 way to build 0 value, i.e. no coins picked

            range(1, numCoins + 1).forEach(ci ->
                    range(1, nInt + 1).forEach(ni -> {
                        long coin = c[ci - 1];
                        ways[ni][ci] = ways[ni][ci - 1];
                        if (ni >= coin) {
                            ways[ni][ci] += ways[ni - (int) coin][ci];
                        }
                    })
            );

            return ways[nInt][numCoins];
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

            bufferedWriter.write(String.valueOf(ways));
            bufferedWriter.close();

            scanner.close();
        }
    }
}
