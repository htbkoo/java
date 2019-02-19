package online.atCoder.beginnerContext118;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MonstersBattleRoyale {
    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        int number = findNumber(testCase);

        output(number);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            int AN = sc.nextInt();
            A.add(AN);
        }

        sc.close();

        return new TestCase(N, A);
    }

    public static int findNumber(TestCase testCase) {
        List<Integer> A = new ArrayList<>(testCase.A);
        int min = findMinimum(A);
        int lastMin;

        do {
            lastMin = min;
            A = attackAllByMin(A, lastMin);
            min = findMinimum(A);

        } while (min < lastMin);

        return min;
    }

    private static List<Integer> attackAllByMin(List<Integer> A, int min) {
        return A.stream()
                .map(AN -> {
                    final int remainder = AN % min;
                    if (remainder >= 1) {
                        return remainder;
                    } else {
                        return AN;
                    }
                })
                .collect(Collectors.toList());
    }

    private static int findMinimum(List<Integer> a) {
        return a.stream().reduce(Math::min).orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    private static int countNumberAllLiked(int[] counts) {
        int number = 0;
        for (int i : counts) {
            if (i == 0) {
                number++;
            }
        }
        return number;
    }

    private static void output(int i) {
        System.out.println(i);
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
