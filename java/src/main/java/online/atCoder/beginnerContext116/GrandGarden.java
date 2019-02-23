package online.atCoder.beginnerContext116;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GrandGarden {
    public static int process(TestCase testCase) {
        final int N = testCase.N;
        List<Integer> h = testCase.h;

        // TODO: optimize sum count
//        int sum = h.stream().mapToInt(i -> i).sum();

        int total = 0;

        while (sum(h) > 0) {
            total += computeAndUpdateHeight(h, N);
        }

        return total;
    }

    private static int computeAndUpdateHeight(List<Integer> h, int N) {
        int totalInOneIteration = 0;
        int start = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < N; ++i) {
            final Integer hi = h.get(i);
            if (hi == 0) {
                totalInOneIteration += computeAndUpdateSection(h, start, minHeap, i);
                minHeap = new PriorityQueue<>();
                start = i + 1;
            } else {
                minHeap.add(hi);
            }
        }

        return totalInOneIteration + computeAndUpdateSection(h, start, minHeap, N);
    }

    private static int computeAndUpdateSection(List<Integer> h, int start, PriorityQueue<Integer> minHeap, int i) {
        final Integer minValue = minHeap.poll();
        if (null != minValue && minValue > 0) {
            updateForSection(h, start, i, minValue);
            return minValue;
        } else {
            return 0;
        }
    }

    private static void updateForSection(List<Integer> h, int startInclusive, int endExclusive, int minValue) {
        for (int i = startInclusive; i < endExclusive; ++i) {
            h.set(i, h.get(i) - minValue);
        }

    }

    private static int sum(List<Integer> h) {
        return h.stream().mapToInt(i -> i).sum();
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
        List<Integer> h = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            h.add(sc.nextInt());
        }

        sc.close();
        return new TestCase(N, h);
    }

    private static void output(int result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int N;
        final List<Integer> h;

        public TestCase(int N, List<Integer> h) {
            this.N = N;
            this.h = h;
        }
    }
}
