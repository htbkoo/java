package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Kangaroo {
    public static class Solution {

        private static final String YES = "YES";
        private static final String NO = "NO";

        // Complete the kangaroo function below.
        static String kangaroo(int x1, int v1, int x2, int v2) {
            return canMeet(x1, v1, x2, v2) ? YES : NO;
        }

        private static boolean canMeet(int x1, int v1, int x2, int v2) {
            if (v2 >= v1) {
                return false;
            } else {
                return areMeetingAtIntegralPosition(x1, v1, x2, v2);
            }
        }

        private static boolean areMeetingAtIntegralPosition(int x1, int v1, int x2, int v2) {
            int time = (x1 - x2) % (v2 - v1);
            return time == 0;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] x1V1X2V2 = scanner.nextLine().split(" ");

            int x1 = Integer.parseInt(x1V1X2V2[0]);

            int v1 = Integer.parseInt(x1V1X2V2[1]);

            int x2 = Integer.parseInt(x1V1X2V2[2]);

            int v2 = Integer.parseInt(x1V1X2V2[3]);

            String result = kangaroo(x1, v1, x2, v2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }

    }
}