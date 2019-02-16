package online.hackerrank.interviewPreparationKit.warmUpChallenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {
    public static class Solution {
        private static final char TARGET = 'a';

        // Complete the repeatedString function below.
        static long repeatedString(String s, long n) {
            final int length = s.length();

            final long fullRepeatCount = getFullRepeatCount(s, n, length);

            long remainderCount = getRemainderCount(s, n, length);

            return fullRepeatCount + remainderCount;
        }

        private static long getFullRepeatCount(String s, long n, int length) {
            final long targetOccurrences = countTargetOccurrences(s, length);
            final long numFullRepeat = n / length;
            return targetOccurrences * numFullRepeat;
        }

        private static long getRemainderCount(String s, long n, int length) {
            final long remainderLength = n % (long) length;
            return countTargetOccurrences(s, remainderLength);
        }

        private static long countTargetOccurrences(String s, long length) {
            long targetOccurrences = 0;
            for (int i = 0; i < length; ++i) {
                if (TARGET == s.charAt(i)) {
                    targetOccurrences++;
                }
            }
            return targetOccurrences;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String s = scanner.nextLine();

            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = repeatedString(s, n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
