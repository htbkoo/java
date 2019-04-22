package online.hackerrank.interviewPreparationKit.Miscellaneous;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FriendCircleQueries {
    public static class Solution {
        private static class DisjointSetForest {
            Map<Integer, DisjointSetTree> trees = new HashMap<>();

            private static class DisjointSetTree {
                DisjointSetTree parent = this;
                int size = 1;

                DisjointSetTree find() {
                    if (this.parent != this) {
                        this.parent = this.parent.find();
                    }
                    return this.parent;
                }
            }

            int union(int person1, int person2) {
                makeSetIfMissing(person1);
                makeSetIfMissing(person2);

                DisjointSetTree shouldBeLarger = trees.get(person1).find();
                DisjointSetTree shouldBeSmaller = trees.get(person2).find();

                if (shouldBeLarger == shouldBeSmaller) {
                    return shouldBeLarger.size;
                }
                if (shouldBeLarger.size < shouldBeSmaller.size) {
                    // swap
                    DisjointSetTree temp = shouldBeLarger;
                    shouldBeLarger = shouldBeSmaller;
                    shouldBeSmaller = temp;
                }
                shouldBeSmaller.parent = shouldBeLarger;
                shouldBeLarger.size = shouldBeLarger.size + shouldBeSmaller.size;
                return shouldBeLarger.size;
            }

            private void makeSetIfMissing(int person) {
                if (!trees.containsKey(person)) {
                    trees.put(person, new DisjointSetTree());
                }
            }
        }

        // Complete the maxCircle function below.
        static int[] maxCircle(int[][] queries) {
            List<Integer> answers = new ArrayList<>();

            DisjointSetForest tree = new DisjointSetForest();

            int max = 0;
            for (int[] query : queries) {
                int person1 = query[0];
                int person2 = query[1];
                int size = tree.union(person1, person2);
                max = Math.max(max, size);
                answers.add(max);
            }

            return answers.stream().mapToInt(i -> i).toArray();
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] queries = new int[q][2];

            for (int i = 0; i < q; i++) {
                String[] queriesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int queriesItem = Integer.parseInt(queriesRowItems[j]);
                    queries[i][j] = queriesItem;
                }
            }

            int[] ans = maxCircle(queries);

            for (int i = 0; i < ans.length; i++) {
                bufferedWriter.write(String.valueOf(ans[i]));

                if (i != ans.length - 1) {
                    bufferedWriter.write("\n");
                }
            }

            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
