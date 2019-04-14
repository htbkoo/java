package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MigratoryBirds {
    public static class Solution {
        private static final int ID_RANGE = 5;

        // Complete the migratoryBirds function below.
        static int migratoryBirds(List<Integer> arr) {
            int[] freq = new int[ID_RANGE];
            arr.forEach(id -> freq[id - 1]++);

            int maxFreqId = ID_RANGE;
            for (int i = ID_RANGE - 1; i >= 1; --i) {
                if (freq[i - 1] >= freq[maxFreqId - 1]) {
                    maxFreqId = i;
                }
            }

            return maxFreqId;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = migratoryBirds(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }

    }
}
