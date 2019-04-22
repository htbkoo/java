package online.hackerrank.interviewPreparationKit.GreedyAlgorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {
    public static class Solution {
        // Complete the getMinimumCost function below.
        static int getMinimumCost(int k, int[] c) {
            Arrays.sort(c);

            int numFlower = 0;
            int totalCost = 0;
            // c is sorted in ascending order so we need to traverse it in reversed order
            for (int i = c.length - 1; i >= 0; --i) {
                int numPurchase = numFlower / k;
                totalCost += (numPurchase + 1) * c[i];

                numFlower++;
            }

            return totalCost;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] c = new int[n];

            String[] cItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }

            int minimumCost = getMinimumCost(k, c);

            bufferedWriter.write(String.valueOf(minimumCost));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
