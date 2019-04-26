package online.hackerrank.practice.algorithms.implementation;

 import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BeautifulDaysAtTheMovies {
    public static class Solution {

        // Complete the beautifulDays function below.
        static int beautifulDays(int i, int j, int k) {
            return (int) IntStream.range(i, j + 1).filter(n -> isBeautiful(n, k)).count();
        }

        private static boolean isBeautiful(int n, int k) {
            int reversedN = reverse(n);
            int diff = Math.abs(n - reversedN);
            return diff % k == 0;
        }

        private static int reverse(int n) {
            return Integer.valueOf(new StringBuilder(String.valueOf(n)).reverse().toString());
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] ijk = scanner.nextLine().split(" ");

            int i = Integer.parseInt(ijk[0]);

            int j = Integer.parseInt(ijk[1]);

            int k = Integer.parseInt(ijk[2]);

            int result = beautifulDays(i, j, k);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
}
