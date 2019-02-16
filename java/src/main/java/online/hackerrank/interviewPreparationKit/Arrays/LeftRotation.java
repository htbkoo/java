package online.hackerrank.interviewPreparationKit.Arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LeftRotation {
    public static class Solution {

        // Complete the rotLeft function below.
        static int[] rotLeft(int[] a, int d) {
            final int length = a.length;
            final int remainder = d % length;

            if (remainder == 0) {
                return a;
            } else {
                final int[] temp = Arrays.copyOf(a, remainder);
                final int numElementsMovedForwarded = length - remainder;
                if (numElementsMovedForwarded >= 0) {
                    System.arraycopy(a, remainder, a, 0, numElementsMovedForwarded);
                }
                System.arraycopy(temp, 0, a, numElementsMovedForwarded, remainder);
                return a;
            }
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nd = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nd[0]);

            int d = Integer.parseInt(nd[1]);

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }

            int[] result = rotLeft(a, d);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
