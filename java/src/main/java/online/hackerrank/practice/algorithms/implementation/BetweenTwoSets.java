package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BetweenTwoSets {
    public static class Solution {
        private static final int RANGE = 100;

        /*
         * Complete the getTotalX function below.
         */
        static int getTotalX(int[] a, int[] b) {
            /*
             * Write your code here.
             */
            return (int) IntStream.range(1, RANGE + 1)
                    .filter(i -> allAreFactors(i, a))
                    .filter(i -> isFactorOfAll(i, b))
                    .count();
        }

        private static boolean allAreFactors(int i, int[] a) {
            return Arrays.stream(a).allMatch(ai -> i % ai == 0);
        }

        private static boolean isFactorOfAll(int i, int[] b) {
            return Arrays.stream(b).allMatch(bi -> bi % i == 0);
        }

        private static final Scanner scan = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nm = scan.nextLine().split(" ");

            int n = Integer.parseInt(nm[0].trim());

            int m = Integer.parseInt(nm[1].trim());

            int[] a = new int[n];

            String[] aItems = scan.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scan.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int total = getTotalX(a, b);

            bw.write(String.valueOf(total));
            bw.newLine();

            bw.close();
        }
    }
}
