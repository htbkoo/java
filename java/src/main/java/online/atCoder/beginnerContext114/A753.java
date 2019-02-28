package online.atCoder.beginnerContext114;

import java.util.Scanner;

public class A753 {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static String process(TestCase testCase) {
        int X = testCase.X;

        return is753(X) ? YES : NO;
    }

    private static boolean is753(int x) {
        return x == 7 || x == 5 || x == 3;
    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final String result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        sc.close();
        return new TestCase(X);
    }

    private static void output(String result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int X;

        public TestCase(int X) {
            this.X = X;
        }
    }
}
