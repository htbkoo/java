package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

public class TheCoinChangeProblem {
    public static class Solution {
        // Complete the getWays function below.
        static long getWays(long n, long[] c) {
            int numCoin = c.length;
            List<Set<List<Integer>>> ways = new ArrayList<>();
            ways.add(new HashSet<>());
            range(1, (int) n + 1).forEach(i -> {
                Set<List<Integer>> combinations = new HashSet<>();
                range(0, numCoin).forEach(ci -> {
                    long coin = c[ci];
                    if (i > coin) {
                        Set<List<Integer>> newCombinations = ways.get((int) (i - coin)).stream().map(combination -> withCoin(combination, ci)).collect(Collectors.toSet());
                        combinations.addAll(newCombinations);
                    } else if (i == coin) {
                        combinations.add(oneCoinCombination(numCoin, ci));
                    }

                });
                ways.add(combinations);
            });

            return ways.get((int) n).size();
        }

        private static List<Integer> withCoin(List<Integer> combination, int index) {
            List<Integer> newCombination = new ArrayList<>(combination);
            newCombination.set(index, combination.get(index) + 1);
            return newCombination;
        }

        private static List<Integer> oneCoinCombination(int numCoin, int index) {
            int[] arr = new int[numCoin];
            arr[index] = 1;
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            long[] c = new long[m];

            String[] cItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m; i++) {
                long cItem = Long.parseLong(cItems[i]);
                c[i] = cItem;
            }

            // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

            long ways = getWays(n, c);

            bufferedWriter.write(String.valueOf(ways));
            bufferedWriter.close();

            scanner.close();
        }
    }
}
