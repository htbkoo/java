package online.hackerrank.practice.algorithms.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppleAndOrange {
    public static class Solution {

        private static class House {
            final int s, t;

            private House(int s, int t) {
                this.s = s;
                this.t = t;
            }

            boolean isWithin(int position) {
                return s <= position && position <= t;
            }
        }

        private static class FruitTree {
            final int treePos;
            final int[] fruitsDists;

            private FruitTree(int treePos, int[] fruitsDists) {
                this.treePos = treePos;
                this.fruitsDists = fruitsDists;
            }

            int count(House house) {
                return (int) Arrays.stream(fruitsDists)
                        .map(this::getFruitPos)
                        .filter(house::isWithin)
                        .count();
            }

            private int getFruitPos(int fruitDist) {
                return treePos + fruitDist;
            }
        }

        // Complete the countApplesAndOranges function below.
        static List<String> countForTest(int s, int t, int a, int b, int[] apples, int[] oranges) {
            List<String> output = new ArrayList<>();
            House house = new House(s, t);

            FruitTree appleTree = new FruitTree(a, apples);
            output.add(String.valueOf(appleTree.count(house)));

            FruitTree orangeTree = new FruitTree(b, oranges);
            output.add(String.valueOf(orangeTree.count(house)));

            return output;
        }

        static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
            countForTest(s, t, a, b, apples, oranges).forEach(System.out::println);
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            String[] st = scanner.nextLine().split(" ");

            int s = Integer.parseInt(st[0]);

            int t = Integer.parseInt(st[1]);

            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            String[] mn = scanner.nextLine().split(" ");

            int m = Integer.parseInt(mn[0]);

            int n = Integer.parseInt(mn[1]);

            int[] apples = new int[m];

            String[] applesItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m; i++) {
                int applesItem = Integer.parseInt(applesItems[i]);
                apples[i] = applesItem;
            }

            int[] oranges = new int[n];

            String[] orangesItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int orangesItem = Integer.parseInt(orangesItems[i]);
                oranges[i] = orangesItem;
            }

            countApplesAndOranges(s, t, a, b, apples, oranges);

            scanner.close();
        }
    }
}
