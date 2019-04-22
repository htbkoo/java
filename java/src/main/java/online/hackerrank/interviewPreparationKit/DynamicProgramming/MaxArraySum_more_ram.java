package online.hackerrank.interviewPreparationKit.DynamicProgramming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MaxArraySum_more_ram {
    public static class Solution {
        // Complete the maxSubsetSum function below.
        static int maxSubsetSum(int[] arr) {
            int n = arr.length;
            int[] maxSums = new int[n + 1];
            maxSums[1] = Math.max(0, arr[0]);
            for (int i = 1; i < n; ++i) {
                int nonAdjacent = Math.max(0, arr[i]) + maxSums[i - 1];
                int adjacent = maxSums[i];
                maxSums[i + 1] = Math.max(nonAdjacent, adjacent);
            }
            return maxSums[n];
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
