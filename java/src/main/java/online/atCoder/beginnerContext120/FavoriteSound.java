package online.atCoder.beginnerContext120;

import java.util.Scanner;

public class FavoriteSound {

    public static String process(TestCase testCase) {
        final int A = testCase.A;
        final int B = testCase.B;
        final int C = testCase.C;

        return String.valueOf(Math.min(C, B / A));
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
        int C = sc.nextInt();

        return new TestCase(A, B, C);
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
        final int C;

        public TestCase(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }
}
