package online.atCoder.grandContext030;

import java.util.Scanner;

public class PoisonousCookies {
    public static int process(TestCase testCase) {
        int A = testCase.A;
        int B = testCase.B;
        int C = testCase.C;

        return B + Math.min(A + B + 1, C);
    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final int result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        sc.close();
        return new TestCase(A, B, C);
    }

    private static void output(int result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int A;
        final int B;
        final int C;

        public TestCase(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }
}
