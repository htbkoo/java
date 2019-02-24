package online.atCoder.beginnerContext115;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChristmasEveEve {
    public static long process(TestCase testCase) {
        final List<Integer> p = testCase.p;
        p.sort((a, b) -> Integer.compare(b, a));

        return p.stream().mapToInt(i -> i).sum() - (p.get(0) / 2);
    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final long result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            p.add(sc.nextInt());
        }

        sc.close();
        return new TestCase(N, p);
    }

    private static void output(long result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int N;
        final List<Integer> p;

        public TestCase(int N, List<Integer> p) {
            this.N = N;
            this.p = p;
        }
    }
}
