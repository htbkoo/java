package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ClimbingTheLeaderboard {
    public static class Solution {
        private static final Comparator<Integer> DESCENDING_ORDER = (a, b) -> Integer.compare(b, a);
        //        private static final Collector<Integer, ?, TreeSet<Integer>> TO_TREE_SET_BY_DESCENDING_ORDER = Collectors.toCollection(() -> new TreeSet<>(DESCENDING_ORDER));
        private static final Collector<Integer, ?, TreeSet<Integer>> TO_TREE_SET = Collectors.toCollection(TreeSet::new);

        // Complete the climbingLeaderboard function below.
        static int[] climbingLeaderboard(int[] scores, int[] alice) {
            TreeSet<Integer> originalDenseScores = Arrays.stream(scores).boxed().collect(TO_TREE_SET);
            List<Integer> denseScoresAsList = new ArrayList<>(originalDenseScores);

            return Arrays.stream(alice)
                    .map(score -> toIndex(denseScoresAsList, score))
                    .toArray();
        }

        private static int toIndex(List<Integer> scores, int score) {
            int index = Collections.binarySearch(scores, score);
            int numScoresInRank = scores.size();
            if (isEqualScore(index)) {
                return numScoresInRank - index;
            } else {
                return numScoresInRank + 2 + index;
            }
        }

        private static boolean isEqualScore(int index) {
            return index >= 0;
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
