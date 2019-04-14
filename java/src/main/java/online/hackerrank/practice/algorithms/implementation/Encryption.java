package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class Encryption {

    public static class Solution {
        // Complete the encryption function below.
        static String encryption(String s) {
            int l = s.length();
            double sqrtLength = Math.sqrt(l);
            int tempRow = (int) Math.floor(sqrtLength);
            int col = (int) Math.ceil(sqrtLength);

            if (tempRow * col < l) {
                tempRow = col;
            }

            // to circumvent silly Java constraints on Stream API, rendering a very useless and restricted API :(
            int row = tempRow;

            List<String> chars = Arrays.asList(s.split(""));

            return IntStream.range(0, col)
                    .mapToObj(c -> toStringRow(s, l, row, col, c))
                    .collect(joining(" "));
        }

        private static String toStringRow(String s, int l, int row, int col, int c) {
            return IntStream.range(0, row)
                    .map(r -> col * r + c)
                    .filter(index -> index < l)
                    .mapToObj(index -> s.substring(index, index + 1))
                    .collect(joining(""));
//            return s.substring(r * col, Math.min(l, (r + 1) * col));
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String s = scanner.nextLine();

            String result = encryption(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }

    }
}
