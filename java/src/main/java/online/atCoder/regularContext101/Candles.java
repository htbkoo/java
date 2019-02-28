package online.atCoder.regularContext101;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Candles {
    public static int process(TestCase testCase) {
        int N = testCase.N;
        int K = testCase.K;
        List<Integer> x = testCase.x;

        int min = Integer.MAX_VALUE;
        for (int i = K - 1; i < N; ++i) {
            int leftMost = x.get(i - (K - 1));
            int rightMost = x.get(i);

            int negative = Math.abs(Math.min(0, leftMost));
            int positive = Math.max(0, rightMost);

            min = Math.min(min, 2 * Math.min(negative, positive) + Math.max(negative, positive));
        }

        return min;
    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final int result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> x = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            x.add(sc.nextInt());
        }

        sc.close();
        return new TestCase(N, K, x);
    }

    private static void output(int result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int N;
        final int K;
        final List<Integer> x;

        public TestCase(int N, int K, List<Integer> x) {
            this.N = N;
            this.K = K;
            this.x = x;
        }
    }
}
