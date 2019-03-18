package online.hackerrank.interviewPreparationKit.StringManipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class SherlockAndTheValidString {
    public static class Solution {

        private static final int ASCII_RANGE = 256;
        private static final String YES = "YES";
        private static final String NO = "NO";

        // Complete the isValid function below.
        static String isValid(String s) {
            final int[] frequencies = countCharFrequencies(s);
            List<Integer> filteredFrequencies = stream(frequencies).filter(i -> i != 0).boxed().collect(toList());
            return isValid(filteredFrequencies) ? YES : NO;
        }

        private static int[] countCharFrequencies(String s) {
            final int[] frequencies = new int[ASCII_RANGE];
            s.chars().forEach(c -> frequencies[c]++);
            return frequencies;
        }

        private static boolean isValid(List<Integer> frequencies) {
            int numUniqueFrequencies = new HashSet<>(frequencies).size();
            switch (numUniqueFrequencies) {
                case 0:
                case 1:
                    return true;
                case 2:
                    return isValidByRemovingOneCharacter(frequencies);
                default:
                    return false;
            }
        }

        // precondition: there are only 2 kind of number in frequencies
        private static boolean isValidByRemovingOneCharacter(List<Integer> frequencies) {
            Map<Integer, Integer> reversedIndices = new HashMap<>();
            frequencies.forEach(f -> {
                if (reversedIndices.containsKey(f)) {
                    reversedIndices.put(f, reversedIndices.get(f) + 1);
                } else {
                    reversedIndices.put(f, 1);
                }
            });

            if (reversedIndices.containsKey(1) && reversedIndices.get(1) == 1) {
                return true;
            }

            int smallerKey = reversedIndices.keySet().stream().mapToInt(i -> i).min().orElseThrow(() -> new IllegalStateException("reversedIndices is empty"));
            int largerKey = reversedIndices.keySet().stream().mapToInt(i -> i).max().orElseThrow(() -> new IllegalStateException("reversedIndices is empty"));

            boolean isFrequencyDifferByOne = (largerKey - smallerKey) <= 1;
            boolean isOnlyOneCharacterAppearsMore = reversedIndices.get(largerKey) == 1;
            return isFrequencyDifferByOne && isOnlyOneCharacterAppearsMore;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String s = scanner.nextLine();

            String result = isValid(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
