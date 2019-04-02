package online.hackerrank.interviewPreparationKit.warmUpChallenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class BirthdayCakeCandles {
    public static class Solution {

        // Complete the birthdayCakeCandles function below.
        static int birthdayCakeCandles(int[] ar) {
            NavigableMap<Integer, Integer> occurrences = countOccurrences(ar);

            return getOccurrenceForLargest(occurrences);
        }

        private static NavigableMap<Integer, Integer> countOccurrences(int[] ar) {
            NavigableMap<Integer, Integer> occurrences = new TreeMap<>();
            Arrays.stream(ar).forEach(ari -> occurrences.put(ari, occurrences.getOrDefault(ari, 0) + 1));
            return occurrences;
        }

        private static int getOccurrenceForLargest(NavigableMap<Integer, Integer> occurrences) {
            return occurrences.lastEntry().getValue();
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int arCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] ar = new int[arCount];

            String[] arItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < arCount; i++) {
                int arItem = Integer.parseInt(arItems[i]);
                ar[i] = arItem;
            }

            int result = birthdayCakeCandles(ar);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
