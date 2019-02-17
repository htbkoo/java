package online.hackerrank.interviewPreparationKit.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTablesIceCreamParlor {
    public static class Solution {

        // Complete the whatFlavors function below.
        static void whatFlavors(int[] cost, int money) {
            Map<Integer, Integer> positions = new HashMap<>();

            for (int i = 0, costLength = cost.length; i < costLength; i++) {
                int c = cost[i];
                int corresponding = money - c;
                final int normalizedPosition = normalizePosition(i);
                if (positions.containsKey(corresponding)) {
                    output(positions.get(corresponding), normalizedPosition);
                    return;
                } else if (!positions.containsKey(c)) {
                    positions.put(c, normalizedPosition);
                }
            }
        }

        private static void output(int pos1, int pos2) {
            System.out.println(String.format("%d %d", pos1, pos2));
        }

        private static int normalizePosition(int rawPos) {
            return rawPos + 1;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                int money = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[] cost = new int[n];

                String[] costItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < n; i++) {
                    int costItem = Integer.parseInt(costItems[i]);
                    cost[i] = costItem;
                }

                whatFlavors(cost, money);
            }

            scanner.close();
        }
    }
}