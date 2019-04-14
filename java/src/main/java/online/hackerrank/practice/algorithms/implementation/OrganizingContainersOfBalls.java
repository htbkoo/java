package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class OrganizingContainersOfBalls {

    public static class Solution {

        private static final String IMPOSSIBLE = "Impossible";
        private static final String POSSIBLE = "Possible";

        // Complete the organizingContainers function below.
        static String organizingContainers(int[][] container) {
            int n = container.length;
            long[] numBallsPerType = new long[n];
            long[] numBallsPerContainer = new long[n];

            range(0, n).forEach(c ->
                    range(0, n).forEach(t -> {
                        numBallsPerContainer[c] += container[c][t];
                        numBallsPerType[t] += container[c][t];
                    })
            );

            List<Long> freqType = asSortedList(numBallsPerType);
            List<Long> freqContainer = asSortedList(numBallsPerContainer);

            return freqContainer.equals(freqType) ? POSSIBLE : IMPOSSIBLE;
        }

        private static List<Long> asSortedList(long[] numBalls) {
            return Arrays.stream(numBalls)
                    .sorted()
                    .boxed()
                    .collect(toList());
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[][] container = new int[n][n];

                for (int i = 0; i < n; i++) {
                    String[] containerRowItems = scanner.nextLine().split(" ");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    for (int j = 0; j < n; j++) {
                        int containerItem = Integer.parseInt(containerRowItems[j]);
                        container[i][j] = containerItem;
                    }
                }

                String result = organizingContainers(container);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            scanner.close();
        }

    }
}
