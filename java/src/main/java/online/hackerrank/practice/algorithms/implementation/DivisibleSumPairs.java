package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DivisibleSumPairs {
    public static class Solution {
        // Complete the divisibleSumPairs function below.
        static int divisibleSumPairs(int n, int k, int[] ar) {
            return IntStream.range(0, n)
                    .map(i -> countDivisibleSumPairs(i, n, k, ar))
                    .sum();
        }

        private static int countDivisibleSumPairs(int i, int n, int k, int[] ar) {
            return (int) IntStream.range(i, n)
                    .filter(j -> keepIfPairSumDivisible(i, j, k, ar))
                    .count();
        }

        private static boolean keepIfPairSumDivisible(int i, int j, int k, int[] ar) {
            return (ar[i] + ar[j]) % k == 0;
        }


        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] ar = new int[n];

            String[] arItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arItem = Integer.parseInt(arItems[i]);
                ar[i] = arItem;
            }

            int result = divisibleSumPairs(n, k, ar);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
