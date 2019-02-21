package online.atCoder.yahooProgrammingContest2019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Streamline {
    private static final Comparator<Integer> DESCENDING_ORDER = (a, b) -> Integer.compare(b, a);

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final long result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> X = new ArrayList<>();
        for (int i = 0; i < M; ++i) {
            X.add(sc.nextInt());
        }

        sc.close();
        return new TestCase(N, M, X);
    }

    public static long process(TestCase testCase) {
        final int M = testCase.M;
        final int N = testCase.N;
        final List<Integer> X = testCase.X;
        X.sort(Integer::compareTo);

        final PriorityQueue<Integer> pathDiffs = new PriorityQueue<>(DESCENDING_ORDER);

        for (int i = 1, length = X.size(); i < length; ++i) {
            pathDiffs.add(X.get(i) - X.get(i - 1));
        }

        for (int i = 0; i < N - 1; ++i) {
            pathDiffs.poll();
        }

        long sum = 0;
        while (!pathDiffs.isEmpty()) {
            sum += pathDiffs.poll();
        }
        return sum;
    }

    private static void output(long result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int N;
        final int M;
        final List<Integer> X;

        public TestCase(int N, int M, List<Integer> X) {
            this.N = N;
            this.M = M;
            this.X = X;
        }
    }
}
