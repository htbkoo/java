package online.atCoder.yahooProgrammingContest2019;

import java.util.Scanner;

public class AntiAdjacency {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final String result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        sc.close();
        return new TestCase(n, k);
    }

    public static String process(TestCase testCase) {
        final int k = testCase.K;
        final int n = testCase.N;

        if (k <= 1) {
            return YES;
        } else {
            return (((n + 1) / 2) >= k) ? YES : NO;
        }
    }


    private static void output(String result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int N, K;

        public TestCase(int n, int k) {
            N = n;
            K = k;
        }
    }
}
