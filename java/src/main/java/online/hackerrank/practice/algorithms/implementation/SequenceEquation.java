package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SequenceEquation {
    public static class Solution {
        // Complete the permutationEquation function below.
        static int[] permutationEquation(int[] p) {
            int length = p.length;
            int[] invertedIndex = new int[length+1];
            IntStream.range(0, length).forEach(i->invertedIndex[p[i]]=i+1);

            int[] answers = new int[length];
            IntStream.range(0, length).forEach(i->answers[i]=invertedIndex[invertedIndex[i+1]]);

            return answers;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] p = new int[n];

            String[] pItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int pItem = Integer.parseInt(pItems[i]);
                p[i] = pItem;
            }

            int[] result = permutationEquation(p);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write("\n");
                }
            }

            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
