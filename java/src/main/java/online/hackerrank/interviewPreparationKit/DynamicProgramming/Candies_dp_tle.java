package online.hackerrank.interviewPreparationKit.DynamicProgramming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Candies_dp_tle {
    public static class Solution {
        private static final int AT_LEAST_ONE_CANDY = 1;

        // Complete the candies function below.
        static long candies(int n, int[] arr) {

            int[] prevPlan = new int[n];
            int[] currPlan = new int[n];

            for (int i = 0; i < n; ++i) {
                prevPlan[i] = AT_LEAST_ONE_CANDY;
            }

            for (int i = 1; i <= n - 1; ++i) {
                // cal j=0
                currPlan[0] = calcCandyNeeded(arr, 0, 1, prevPlan);

                for (int j = 1; j < n - 1; ++j) {
                    // cal 1<=j<=n-2
                    currPlan[j] = Math.max(calcCandyNeeded(arr, j, j - 1, prevPlan), calcCandyNeeded(arr, j, j + 1, prevPlan));
                }

                // cal j=n-1
                currPlan[n - 1] = calcCandyNeeded(arr, n - 1, n - 1 - 1, prevPlan);

                prevPlan = currPlan;
                currPlan = new int[n];
            }

            return Arrays.stream(prevPlan).sum();
        }

        private static int calcCandyNeeded(int[] arr, int student, int otherStudent, int[] prevPlan) {
            boolean isHigherRating = arr[student] > arr[otherStudent];
            if (isHigherRating) {
                return prevPlan[otherStudent] + 1;
            } else {
                return prevPlan[student];
            }
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
