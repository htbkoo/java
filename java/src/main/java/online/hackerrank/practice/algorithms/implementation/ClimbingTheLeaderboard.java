package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ClimbingTheLeaderboard {
    public static class Solution {


        // Complete the climbingLeaderboard function below.
        static int[] climbingLeaderboard(int[] scores, int[] alice) {
            return Arrays.stream(alice)
                    .map(score -> toIndex(scores, score))
                    .toArray();
        }

        private static int toIndex(int[] scores, int score) {
            TreeSet<Integer> set = Arrays.stream(scores).boxed().collect(Collectors.toCollection(() -> new TreeSet<>((a, b) -> Integer.compare(b, a))));
            set.add(score);

            return set.contains(score) ? set.headSet(score).size() + 1 : -1;
        }


        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int scoresCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] scores = new int[scoresCount];

            String[] scoresItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < scoresCount; i++) {
                int scoresItem = Integer.parseInt(scoresItems[i]);
                scores[i] = scoresItem;
            }

            int aliceCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] alice = new int[aliceCount];

            String[] aliceItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < aliceCount; i++) {
                int aliceItem = Integer.parseInt(aliceItems[i]);
                alice[i] = aliceItem;
            }

            int[] result = climbingLeaderboard(scores, alice);

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
