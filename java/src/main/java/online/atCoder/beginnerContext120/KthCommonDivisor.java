package online.atCoder.beginnerContext120;

import java.util.Scanner;

public class KthCommonDivisor {

    public static String process(TestCase testCase) {
        final int A = testCase.A;
        final int B = testCase.B;
        int K = testCase.K;

        final int range = Math.min(A, B);

        for (int i = range; i >= 1; --i) {
            if ((A % i == 0) && (B % i == 0)) {
                K--;
                if (K == 0) {
                    return String.valueOf(i);
                }
            }

        }

        throw new IllegalArgumentException("no solution");
    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final String result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int K = sc.nextInt();

        return new TestCase(A, B, K);
    }

    private static IllegalArgumentException unknownN(int N) {
        return new IllegalArgumentException("Unknown N: " + N);
    }

    private static void output(String result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int A;
        final int B;
        final int K;

        public TestCase(int A, int B, int K) {
            this.A = A;
            this.B = B;
            this.K = K;
        }
    }
}
