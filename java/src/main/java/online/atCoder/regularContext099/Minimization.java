package online.atCoder.regularContext099;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Minimization {
    private static final int MINIMUM = 1;

    public static String process(TestCase testCase) {
        final int N = testCase.N;
        final int K = testCase.K;

        final int countToConvert = N - 1;
        final int conversionPerOp = K - 1;
        return String.valueOf((countToConvert + conversionPerOp - 1) / conversionPerOp);
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
        int K = sc.nextInt();

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            A.add(sc.nextInt());
        }

        return new TestCase(N, K, A);
    }

    private static void output(String result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int N;
        final int K;
        final List<Integer> A;

        public TestCase(int N, int K, List<Integer> A) {
            this.N = N;
            this.K = K;
            this.A = A;
        }
    }
}
