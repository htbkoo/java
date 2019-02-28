package online.atCoder.beginnerContext113;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ID {
    private static final BigDecimal CONVERSION = new BigDecimal("0.006");
    private static final String SIX_DIGIT_ZEROS = "000000";

    public static List<String> process(TestCase testCase) {
        int N = testCase.N;
        int M = testCase.M;
        List<Integer> P = testCase.P;
        List<Integer> Y = testCase.Y;

        return asIds(M, P, Y);
    }

    private static List<String> asIds(int M, List<Integer> P, List<Integer> Y) {
        final Map<Integer, List<Integer>> cities = citiesPerPrefectureSortedByYear(M, P, Y);
        Map<Integer, Integer> cityOrderPerYear = cityOrderPerYear(M, P, Y);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < M; ++i) {
            final int prefecture = P.get(i);
            final int year = Y.get(i);
            int order = cityOrderPerYear.get(year);
//            int order = cityOrderPerYear.getOrDefault(year, 0);
            ids.add(asId(prefecture, order));
        }

        return ids;
    }

    private static String asId(int prefecture, int order) {
        return padLeft(SIX_DIGIT_ZEROS, String.valueOf(prefecture)) + padLeft(SIX_DIGIT_ZEROS, String.valueOf(order));
    }

    private static String padLeft(String format, String value) {
        return format.substring(Math.min(format.length(), value.length())) + value;
    }

    private static Map<Integer, Integer> cityOrderPerYear(int M, List<Integer> P, List<Integer> Y) {
        final Map<Integer, List<Integer>> cities = citiesPerPrefectureSortedByYear(M, P, Y);

        Map<Integer, Integer> reverseIndex = new HashMap<>();
        for (List<Integer> years : cities.values()) {
            for (int i = 0, length = years.size(); i < length; ++i) {
                reverseIndex.put(years.get(i), i + 1);
            }
        }
        return reverseIndex;
    }

    private static Map<Integer, List<Integer>> citiesPerPrefectureSortedByYear(int m, List<Integer> p, List<Integer> y) {
        Map<Integer, List<Integer>> citiesPerPrefecture = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            final int prefecture = p.get(i);
            final int year = y.get(i);
            if (citiesPerPrefecture.containsKey(prefecture)) {
                citiesPerPrefecture.get(prefecture).add(year);
            } else {
                citiesPerPrefecture.put(prefecture, new ArrayList<>(Collections.singletonList(year)));
            }
        }
        citiesPerPrefecture.forEach((prefecture, years) -> years.sort(Integer::compareTo));
        return citiesPerPrefecture;
    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final List<String> result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> P = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();
        for (int i = 0; i < M; ++i) {
            P.add(sc.nextInt());
            Y.add(sc.nextInt());
        }

        sc.close();
        return new TestCase(N, M, P, Y);
    }

    private static void output(List<String> result) {
        result.forEach(System.out::println);
    }

    public static class TestCase {
        final int N;
        final int M;
        final List<Integer> P;
        final List<Integer> Y;

        public TestCase(int N, int M, List<Integer> P, List<Integer> Y) {
            this.N = N;
            this.M = M;
            this.P = P;
            this.Y = Y;
        }
    }
}
