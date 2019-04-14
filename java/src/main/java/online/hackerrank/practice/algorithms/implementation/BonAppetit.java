package online.hackerrank.practice.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BonAppetit {
    public static class Solution {

        private static final String NO_OVERCHARGE = "Bon Appetit";

        // Complete the bonAppetit function below.
        static String testBonAppetit(List<Integer> bill, int k, int b) {
            int bActual = (bill.stream().mapToInt(i -> i).sum() - bill.get(k)) / 2;
            if (b > bActual) {
                return String.valueOf(b - bActual);
            } else {
                return NO_OVERCHARGE;
            }
        }

        static void bonAppetit(List<Integer> bill, int k, int b) {
            System.out.println(testBonAppetit(bill, k, b));
        }

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int b = Integer.parseInt(bufferedReader.readLine().trim());

            bonAppetit(bill, k, b);

            bufferedReader.close();
        }
    }
}
