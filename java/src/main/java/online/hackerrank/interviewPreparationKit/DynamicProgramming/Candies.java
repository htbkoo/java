package online.hackerrank.interviewPreparationKit.DynamicProgramming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Candies {
    public static class Solution {
        // Complete the candies function below.
        static long candies(int n, int[] arr) {
            int[] forward = new int[n];
            forward[0] = 1;
            for (int i = 1; i < n; ++i) {
                forward[i] = (arr[i] > arr[i - 1]) ? forward[i - 1] + 1 : 1;
            }

            int[] backward = new int[n];
            backward[n - 1] = 1;
            for (int i = n - 2; i >= 0; --i) {
                backward[i] = (arr[i] > arr[i + 1]) ? backward[i + 1] + 1 : 1;
            }

            long sum = 0;
            for (int i = 0; i < n; ++i) {
                sum += Math.max(forward[i], backward[i]);
            }

            return sum;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                int arrItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                arr[i] = arrItem;
            }

            long result = candies(n, arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
