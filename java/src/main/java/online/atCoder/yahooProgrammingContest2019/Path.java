package online.atCoder.yahooProgrammingContest2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Path {
    private static final String YES = "YES";
    private static final String NO = "NO";

    private static final int NUM_ROADS = 3;
    private static final int NUM_CITIES = 4;

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final String result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        List<List<Integer>> roads = new ArrayList<>();
        for (int i = 0; i < NUM_ROADS; ++i) {
            List<Integer> road = new ArrayList<>();
            int a = sc.nextInt();
            int b = sc.nextInt();
            road.add(a);
            road.add(b);

            roads.add(road);
        }

        sc.close();
        return new TestCase(roads);
    }

    public static String process(TestCase testCase) {
        final List<List<Integer>> roads = testCase.roads;
        int[] cityCounts = new int[NUM_CITIES];

        roads.forEach(road -> road.forEach(rawCity -> cityCounts[rawCity - 1]++));

        int oddCount = 0;
        for (int count : cityCounts) {
            if (count == 0) {
                return NO;
            }
            final boolean isOdd = count % 2 != 0;
            if (isOdd) {
                oddCount++;
            }
        }
        final boolean isPossible = oddCount == 0 || oddCount == 2;
        return isPossible ? YES : NO;
    }


    private static void output(String result) {
        System.out.println(result);
    }

    public static class TestCase {
        final List<List<Integer>> roads;

        public TestCase(List<List<Integer>> roads) {
            this.roads = roads;
        }
    }
}
