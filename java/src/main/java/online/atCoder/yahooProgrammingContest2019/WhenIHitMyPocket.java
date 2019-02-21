package online.atCoder.yahooProgrammingContest2019;

import java.util.Scanner;

public class WhenIHitMyPocket {
    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final long result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        long K = sc.nextLong();
        long A = sc.nextLong();
        long B = sc.nextLong();

        sc.close();
        return new TestCase(K, A, B);
    }

    public static long process(TestCase testCase) {
        long K = testCase.K;
        long A = testCase.A;
        long B = testCase.B;

        boolean isPossibleToFullExchange = K >= (A - 1 + 2);
        final long diff = B - A;
        boolean isBeneficialToExchange = diff > 1;
        if (isPossibleToFullExchange && isBeneficialToExchange) {
            final long numRemainingOps = K - (A - 1);
            return A + numRemainingOps / 2 * diff + numRemainingOps % 2;
        } else {
            return 1L + K;
        }
    }

    private static void output(long result) {
        System.out.println(result);
    }

    public static class TestCase {
        final long K;
        final long A;
        final long B;

        public TestCase(long k, long a, long b) {
            K = k;
            A = a;
            B = b;
        }
    }
}
