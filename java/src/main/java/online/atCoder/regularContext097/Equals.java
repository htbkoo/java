package online.atCoder.regularContext097;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static java.util.stream.IntStream.range;

public class Equals {
    public static String process(TestCase testCase) {
        final int N = testCase.N;
        final int M = testCase.M;
        final List<Integer> p = testCase.p;
        final List<Integer> x = testCase.x;
        final List<Integer> y = testCase.y;

        Map<Integer, Set<Integer>> disjointSets = buildDisjointSets(N, M, x, y);

        return "";
    }

    private static Map<Integer, Set<Integer>> buildDisjointSets(int N, int M, List<Integer> x, List<Integer> y) {
        final Map<Integer, Set<Integer>> disjointSets = new HashMap<>();
        range(0, N).forEach(initializeDisjointSets(disjointSets));

        range(0, M).forEach(i -> {
            final int xi = x.get(i);
            final int yi = y.get(i);

            final Set<Integer> setXi = disjointSets.get(xi);
            final Set<Integer> setYi = disjointSets.get(yi);

            mergeSets(setXi, setYi);
            final Set<Integer> newSet = mergeSets(setXi, setYi);
            disjointSets.put(xi, newSet);
            disjointSets.put(yi, newSet);
        });

        return disjointSets;
    }

    private static IntConsumer initializeDisjointSets(Map<Integer, Set<Integer>> disjointSets) {
        return i -> disjointSets.put(i + 1, new HashSet<>(singletonList(i + 1)));
    }

        private static Set<Integer> mergeSets(Set<Integer> setXi, Set<Integer> setYi) {
//    private static void mergeSets(Set<Integer> setXi, Set<Integer> setYi) {
        setXi.addAll(setYi);
        setYi.addAll(setXi);
        return setXi;
    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final String result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> p = readList(sc, N);

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        range(0, M).forEach(i -> {
            x.add(sc.nextInt());
            y.add(sc.nextInt());
        });

        return new TestCase(N, M, p, x, y);
    }

    private static List<Integer> readList(Scanner sc, int N) {
        return range(0, N).mapToObj(i -> sc.nextInt()).collect(Collectors.toList());
    }

    private static void output(String result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int N;
        final int M;
        final List<Integer> p;
        final List<Integer> x;
        final List<Integer> y;

        public TestCase(int N, int M, List<Integer> p, List<Integer> x, List<Integer> y) {
            this.N = N;
            this.M = M;
            this.p = p;
            this.x = x;
            this.y = y;
        }
    }
}
