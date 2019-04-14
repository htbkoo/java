package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BirthdayChocolate {
    public static class Solution {
        // Complete the birthday function below.
        static int birthday(List<Integer> s, int d, int m) {
            // to circumvent Java's stream API constraint :(
            int sum = s.subList(0, m).stream().mapToInt(i -> i).sum();
            int count = (sum == d) ? 1 : 0;
            for (int i = m, n = s.size(); i < n; i++) {
                sum = sum + s.get(i) - s.get(i - m);
                count += (sum == d) ? 1 : 0;
            }

            return count;
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
