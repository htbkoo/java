package online.hackerrank.interviewPreparationKit.GreedyAlgorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LuckBalance {
    public static class Solution {

        private static final int IMPORTANT = 1;

        // Complete the luckBalance function below.
        static int luckBalance(int k, int[][] contests) {
            // first idea: add all luck if the contest is not important, then plus the luck from number of important contest that can be lost (i.e. number of important contest - k)
            List<Integer> importantContestLucks = new ArrayList<>();

            int totalLuck = 0;
            for (int[] contest : contests) {
                int luck = contest[0];
                boolean isImportant = contest[1] == IMPORTANT;
                if (isImportant) {
                    importantContestLucks.add(luck);
                } else {
                    totalLuck += luck;
                }
            }

            sortDescendingOrder(importantContestLucks);
            int size = importantContestLucks.size();
            for (int i = 0, limit = Math.min(k, size); i < limit; i++) {
                totalLuck += importantContestLucks.get(i);
            }
            for (int i = k; i < size; i++) {
                totalLuck -= importantContestLucks.get(i);
            }

            return totalLuck;
        }

        private static void sortDescendingOrder(List<Integer> importantContestLucks) {
            importantContestLucks.sort((l1, l2) -> Integer.compare(l2, l1));
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[][] contests = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] contestsRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int contestsItem = Integer.parseInt(contestsRowItems[j]);
                    contests[i][j] = contestsItem;
                }
            }

            int result = luckBalance(k, contests);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
