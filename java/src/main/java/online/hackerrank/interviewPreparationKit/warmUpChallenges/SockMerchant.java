package online.hackerrank.interviewPreparationKit.warmUpChallenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SockMerchant {
    public static class Solution {
        private static final int MAX_ARI = 100;

        // Complete the sockMerchant function below.
        static int sockMerchant(int n, int[] ar) {
            final int[] counts = new int[MAX_ARI + 1];

            Arrays.stream(ar).forEach(color -> counts[color]++);

            return Arrays.stream(counts)
                    .map(count -> count / 2)
                    .sum();
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] ar = new int[n];

            String[] arItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arItem = Integer.parseInt(arItems[i]);
                ar[i] = arItem;
            }

            int result = sockMerchant(n, ar);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }

}
