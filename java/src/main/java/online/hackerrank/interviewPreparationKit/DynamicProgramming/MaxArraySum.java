package online.hackerrank.interviewPreparationKit.DynamicProgramming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MaxArraySum {
    public static class Solution {
        // Complete the maxSubsetSum function below.
        static int maxSubsetSum(int[] arr) {
            int n = arr.length;
            int nonAdjacent = 0;
            int adjacent = atLeastZero(arr, 0);
            for (int i = 1; i < n; ++i) {
                int current = atLeastZero(arr, i);
                int max = Math.max(current + nonAdjacent, adjacent);
                nonAdjacent = adjacent;
                adjacent = max;
            }
            return adjacent;
        }

        private static int atLeastZero(int[] arr, int i) {
            return Math.max(0, arr[i]);
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int res = maxSubsetSum(arr);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
