package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class BirthdayChocolate {
    public static class Solution {
        private static class State {
            static final State EMPTY = new State(Collections.emptyList());
            private final List<Set<Integer>> configurations;

            private State(List<Set<Integer>> configurations) {
                this.configurations = configurations;
            }

            static boolean isNewStateValid(List<Integer> s, int newIndex) {
                return false;
            }

            int getNumWays() {
                return configurations.size();
            }
        }

        // Complete the birthday function below.
        static int birthday(List<Integer> s, int d, int m) {
            int n = s.size();
            int[][][] states = initialStates(d, m, n);

            range(1, m + 1).forEach(i ->
                    range(1, d + 1).forEach(j ->
                            range(1, n + 1).forEach(k -> {
                                        Integer value = s.get(k - 1);
                                        int newNumWays = states[i][j][k - 1] + (((j - value) >= 0) ? states[i - 1][j - value][k - 1] : 0);
                                        states[i][j][k] = newNumWays;
                                    }
                            )
                    )
            );

            return states[m][d][n];
        }

        private static int[][][] initialStates(int d, int m, int n) {
            int[][][] states = new int[m + 1][d + 1][n + 1];

            // states[0][0][:] all have 1 possible configuration which is the empty set (i.e. picking no chocolate)
//            range(0, d + 1).forEach(j ->
            range(0, n + 1).forEach(k ->
                            states[0][0][k] = 1
//                    )
            );

            // states[1:][:][0] and states[1:][0][:] have no possible configurations because 1<=s[i]<=5
            range(1, m + 1).forEach(i -> {
                        range(0, d + 1).forEach(j ->
                                states[i][j][0] = 0
                        );
                        range(0, n + 1).forEach(k ->
                                states[i][0][k] = 0
                        );
                    }
            );
            return states;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int d = Integer.parseInt(dm[0]);

            int m = Integer.parseInt(dm[1]);

            int result = birthday(s, d, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
