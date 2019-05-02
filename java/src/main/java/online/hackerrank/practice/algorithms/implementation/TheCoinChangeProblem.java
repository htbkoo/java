package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TheCoinChangeProblem {
    public static class Solution {
        // Complete the getWays function below.
        static long getWays(long n, long[] c) {
            List<Set<Set<Long>>> ways = new ArrayList<>();
            ways.add(new HashSet<>());
//long[] ways = new long[n+1];
            IntStream.range(1, (int)n+1).forEach(i->{
                Set<Set<Long>> combinations = new HashSet<>();
                Arrays.stream(c).forEach(coin->{
                    if (i>coin){
                        combinations.addAll(ways.get((int)(i-coin)).stream().map(combination->withCoin(combination, coin)).collect(Collectors.toList()));
//ways[i]+=ways[i-coin];
                    }else if (i==coin){
                        combinations.add(new HashSet<>(Collections.singletonList(coin)));
//ways[i]+=1;
//}else{
                    }
                });
                ways.add(combinations);
            });

            return ways.get((int)n).size();
//            return ways[n];
        }

        private static Set<Long> withCoin(Set<Long> combination, long coin){
            Set<Long> newCombination = new HashSet<>(combination);
            newCombination.add(coin);
            return  newCombination;
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
