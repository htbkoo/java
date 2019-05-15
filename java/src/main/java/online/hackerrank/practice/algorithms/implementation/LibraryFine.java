package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LibraryFine {
    public static class Solution {

        private static final int FIXED_FINE = 10000;
        private static final int FINE_PER_DAY = 15;
        private static final int FINE_PER_MONTH = 500;
        private static final int NO_FINE = 0;

        private static class Date {
            final int day;
            final int month;
            final int year;

            Date(int day, int month, int year) {
                this.day = day;
                this.month = month;
                this.year = year;
            }

            boolean isOnOrBefore(Date other) {
                return isEarlierYear(other) || isSameYearAndEarlierMonth(other) || isSameYearMonthAndSameOrEarlierDay(other);
            }

            boolean isSameMonthAndYearAs(Date other) {
                return isSameYearAs(other) && month == other.month;
            }

            boolean isSameYearAndEarlierMonth(Date other) {
                return isSameYearAs(other) && month < other.month;
            }

            int getNumDaysLaterThan(Date dueDate) {
                return day - dueDate.day;
            }

            int getNumMonthsLaterThan(Date dueDate) {
                return month - dueDate.month;
            }

            private boolean isSameYearAs(Date other) {
                return year == other.year;
            }

            private boolean isEarlierYear(Date other) {
                return year < other.year;
            }

            private boolean isSameYearMonthAndSameOrEarlierDay(Date other) {
                return isSameMonthAndYearAs(other) && day <= other.day;
            }
        }

        // Complete the libraryFine function below.
        static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
            Date returnedDate = new Date(d1, m1, y1);
            Date dueDate = new Date(d2, m2, y2);

            if (returnedDate.isOnOrBefore(dueDate)) {
                return NO_FINE;
            } else if (returnedDate.isSameMonthAndYearAs(dueDate)) {
                return FINE_PER_DAY * returnedDate.getNumDaysLaterThan(dueDate);
            } else if (returnedDate.isSameYearAs(dueDate)) {
                return FINE_PER_MONTH * returnedDate.getNumMonthsLaterThan(dueDate);
            } else {
                return FIXED_FINE;
            }
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] d1M1Y1 = scanner.nextLine().split(" ");

            int d1 = Integer.parseInt(d1M1Y1[0]);

            int m1 = Integer.parseInt(d1M1Y1[1]);

            int y1 = Integer.parseInt(d1M1Y1[2]);

            String[] d2M2Y2 = scanner.nextLine().split(" ");

            int d2 = Integer.parseInt(d2M2Y2[0]);

            int m2 = Integer.parseInt(d2M2Y2[1]);

            int y2 = Integer.parseInt(d2M2Y2[2]);

            int result = libraryFine(d1, m1, y1, d2, m2, y2);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
