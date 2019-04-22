package online.hackerrank.interviewPreparationKit.GreedyAlgorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumAbsoluteDifferenceInAnArray {
    public static class Solution {

        // Complete the minimumAbsoluteDifference function below.
        static int minimumAbsoluteDifference(int[] arr) {
            // algorithm idea: sort the array, the calculate the difference and pick the minimum difference
            // Time complexity: O(n lg n)
            // assuming the arr is mutable, otherwise we should clone the array first
            Arrays.sort(arr);

            int min = arr[1] - arr[0];
            for (int i = 2, length = arr.length; i < length; ++i) {
                min = Math.min(min, arr[i] - arr[i - 1]);

                if (min == 0) { // a short cut to end the search slightly faster as 0 is the minimum possible value
                    return 0;
                }
            }

            return min;
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

            int result = minimumAbsoluteDifference(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
