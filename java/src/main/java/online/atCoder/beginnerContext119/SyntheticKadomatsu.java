package online.atCoder.beginnerContext119;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SyntheticKadomatsu {
    private static final int MP_CONSUMPTION_COMPOSITION_MAGIC = 10;
    private static final int IMPOSSIBLE = 10_000_000;

    public static int process(TestCase testCase) {
        return dfs(testCase, 0, 0, 0, 0);
    }

    private static int dfs(TestCase testCase, int curr, int a, int b, int c) {
        int N = testCase.N;
        int A = testCase.A;
        int B = testCase.B;
        int C = testCase.C;

        if (curr == N) {
            if (a > 0 && b > 0 && c > 0) {
                return diff(a, A) + diff(b, B) + diff(c, C) - 3 * MP_CONSUMPTION_COMPOSITION_MAGIC;
            } else {
                return IMPOSSIBLE;
            }
        } else {
            List<Integer> l = testCase.l;
            final int value = l.get(curr);
            int v0 = dfs(testCase, curr + 1, a, b, c);
            int v1 = dfs(testCase, curr + 1, a + value, b, c) + MP_CONSUMPTION_COMPOSITION_MAGIC;
            int v2 = dfs(testCase, curr + 1, a, b + value, c) + MP_CONSUMPTION_COMPOSITION_MAGIC;
            int v3 = dfs(testCase, curr + 1, a, b, c + value) + MP_CONSUMPTION_COMPOSITION_MAGIC;

            return Math.min(Math.min(Math.min(v0, v1), v2), v3);
        }
    }

    private static int diff(int actual, int target) {
        return Math.abs(actual - target);
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
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            l.add(sc.nextInt());
        }

        sc.close();
        return new TestCase(N, A, B, C, l);
    }

    private static void output(int result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int N;
        final int A;
        final int B;
        final int C;
        final List<Integer> l;

        public TestCase(int N, int A, int B, int C, final List<Integer> l) {
            this.N = N;
            this.A = A;
            this.B = B;
            this.C = C;
            this.l = l;
        }
    }
}
