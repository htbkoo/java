package online.atCoder.regularContext100;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LinearApproximation {
    public static long process(TestCase testCase) {
        int N = testCase.N;
        List<Integer> A = testCase.A;

        List<Integer> differences = IntStream.range(0, N)
                .map(i -> i - A.get(i))
                .sorted()
                .boxed()
                .collect(toList());

        int mid = N / 2;
        final int midDiff = differences.get(mid);

        return sadness(differences, midDiff);
    }

    private static long sadness(Collection<Integer> differences, int midDiff) {
        return differences.stream()
                .mapToLong(i -> Math.abs(i - midDiff))
                .sum();
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

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            A.add(sc.nextInt());
        }

        sc.close();
        return new TestCase(N, A);
    }

    private static void output(long result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int N;
        final List<Integer> A;

        public TestCase(int N, List<Integer> A) {
            this.N = N;
            this.A = A;
        }
    }

}
