package online.atCoder.beginnerContext115;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChristmasEve {
    public static long process(TestCase testCase) {
        final int K = testCase.K;
        final List<Integer> h = testCase.h;
        final int N = h.size();

        h.sort(Integer::compareTo);

        long minDiff = h.get(K - 1) - h.get(0);

        for (int i = 1; (i + K - 1) < N; ++i) {
            minDiff = Math.min(h.get(i + K - 1) - h.get(i), minDiff);
        }

        return minDiff;
    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final long result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> h = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            h.add(sc.nextInt());
        }

        sc.close();
        return new TestCase(N, K, h);
    }

    private static void output(long result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int N;
        final int K;
        final List<Integer> h;

        public TestCase(int N, int K, List<Integer> h) {
            this.N = N;
            this.K = K;
            this.h = h;
        }
    }
}
