package online.atCoder.beginnerContext116;

import java.util.Scanner;

public class RightTriangle {
    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final int result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int AB = sc.nextInt();
        int BC = sc.nextInt();
        int CA = sc.nextInt();

        sc.close();
        return new TestCase(AB, BC, CA);
    }

    public static int process(TestCase testCase) {
        int AB = testCase.AB;
        int BC = testCase.BC;
        int CA = testCase.CA;

        return AB * BC / 2;
    }

    private static void output(int result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int AB;
        final int BC;
        final int CA;

        public TestCase(int AB, int BC, int CA) {
            this.AB = AB;
            this.BC = BC;
            this.CA = CA;
        }
    }
}
