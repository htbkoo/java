package online.hackerrank.interviewPreparationKit.Graphs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class RoadsAndLibraries {
    public static class Solution {
        private static class DisjointSetForest {

            private static class DisjointSetTree {
                final int id;
                DisjointSetTree parent = this;
                int size = 1;

                private DisjointSetTree(int id) {
                    this.id = id;
                }

                @Override
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (o == null || getClass() != o.getClass()) return false;
                    DisjointSetTree that = (DisjointSetTree) o;
                    return Objects.equals(parent, that.parent);
                }

                @Override
                public int hashCode() {
                    if (this.parent == this) {
                        return id;
                    } else {
                        return find().hashCode();
                    }
                }

                public DisjointSetTree find() {
                    if (this.parent != this) {
                        this.parent = this.parent.find();
                    }
                    return this.parent;
                }
            }

            final DisjointSetTree[] trees;

            DisjointSetForest(int n) {
                trees = new DisjointSetTree[n];
                for (int i = 0; i < n; ++i) {
                    trees[i] = new DisjointSetTree(i);
                }
            }

            void union(int u, int v) {
                DisjointSetTree shouldBeLarger = trees[u - 1].find();
                DisjointSetTree shouldBeSmaller = trees[v - 1].find();

                if (shouldBeLarger == shouldBeSmaller) {
                    return;
                } else {
                    if (shouldBeLarger.size < shouldBeSmaller.size) {
                        // swap
                        DisjointSetTree temp = shouldBeLarger;
                        shouldBeLarger = shouldBeSmaller;
                        shouldBeSmaller = temp;
                    }
                    shouldBeSmaller.parent = shouldBeLarger;
                    shouldBeLarger.size = shouldBeLarger.size + shouldBeSmaller.size;
                }
            }

            Set<DisjointSetTree> getAllDisjoint() {
                return new HashSet<>(Arrays.asList(trees));
            }
        }

        // Complete the roadsAndLibraries function below.
        static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
            boolean isBuildingLibrariesCheaper = c_lib <= c_road;
            if (isBuildingLibrariesCheaper) {
                return (long) n * (long) c_lib;
            } else {
                DisjointSetForest forest = new DisjointSetForest(n);
                for (int[] city : cities) {
                    int u = city[0];
                    int v = city[1];
                    forest.union(u, v);
                }

                Set<DisjointSetForest.DisjointSetTree> disjointTress = forest.getAllDisjoint();
                long totalCost = 0;
                for (DisjointSetForest.DisjointSetTree tree : disjointTress) {
                    long numRoadsNeeded = tree.find().size - 1;
                    long cost = numRoadsNeeded * (long) c_road + (long) c_lib;
                    totalCost += cost;
                }
                return totalCost;
            }
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                String[] nmC_libC_road = scanner.nextLine().split(" ");

                int n = Integer.parseInt(nmC_libC_road[0]);

                int m = Integer.parseInt(nmC_libC_road[1]);

                int c_lib = Integer.parseInt(nmC_libC_road[2]);

                int c_road = Integer.parseInt(nmC_libC_road[3]);

                int[][] cities = new int[m][2];

                for (int i = 0; i < m; i++) {
                    String[] citiesRowItems = scanner.nextLine().split(" ");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    for (int j = 0; j < 2; j++) {
                        int citiesItem = Integer.parseInt(citiesRowItems[j]);
                        cities[i][j] = citiesItem;
                    }
                }

                long result = roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            scanner.close();
        }
    }
}
