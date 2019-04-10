package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GradingStudents {
    public static class Solution {

        private static final int THRESHOLD = 38;

        /*
         * Complete the gradingStudents function below.
         */
        static int[] gradingStudents(int[] grades) {
            /*
             * Write your code here.
             */
            return Arrays.stream(grades)
                    .map(Solution::roundGradeIfNeeded)
                    .toArray();
        }

        private static int roundGradeIfNeeded(int grade) {
            if (isRoundingNeeded(grade)) {
                return rounded(grade);
            } else {
                return grade;
            }
        }

        private static int rounded(int grade) {
            int quotient = grade / 5;
            int remainder = grade % 5;
            int roundedPart = remainder >= 3 ? 5 : remainder;
            return 5 * quotient + roundedPart;
        }

        private static boolean isRoundingNeeded(int grade) {
            return grade >= THRESHOLD;
        }

        private static final Scanner scan = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(scan.nextLine().trim());

            int[] grades = new int[n];

            for (int gradesItr = 0; gradesItr < n; gradesItr++) {
                int gradesItem = Integer.parseInt(scan.nextLine().trim());
                grades[gradesItr] = gradesItem;
            }

            int[] result = gradingStudents(grades);

            for (int resultItr = 0; resultItr < result.length; resultItr++) {
                bw.write(String.valueOf(result[resultItr]));

                if (resultItr != result.length - 1) {
                    bw.write("\n");
                }
            }

            bw.newLine();

            bw.close();
        }
    }
}
