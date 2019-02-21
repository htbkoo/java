package online.atCoder.yahooProgrammingContest2019;

import java.math.BigDecimal;
import java.util.Scanner;

public class EntranceExamination {
    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final BigDecimal result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int X = sc.nextInt();

        sc.close();
        return new TestCase(T, X);
    }

    public static BigDecimal process(TestCase testCase) {
        int T = testCase.T;
        int X = testCase.X;

        return new BigDecimal(T).divide(new BigDecimal(X), 10, BigDecimal.ROUND_HALF_UP);
    }

    private static void output(BigDecimal result) {
        System.out.println(result.toString());
    }

    public static class TestCase {
        final int T;
        final int X;

        public TestCase(int t, int x) {
            T = t;
            X = x;
        }
    }
}
