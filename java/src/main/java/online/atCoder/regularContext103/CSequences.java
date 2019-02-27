package online.atCoder.regularContext103;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CSequences {
    private static final int RANGE = 100_001; // 1<=v<=10^5

    public static int process(TestCase testCase) {
        int n = testCase.n;
        List<Integer> v = testCase.v;

        int[] evenOccurrences = new int[RANGE];
        int[] oddOccurrences = new int[RANGE];

        for (int i = 0, length = v.size(); i < length; ++i) {
            int value = v.get(i);
            boolean isEven = i % 2 == 0;
            if (isEven) {
                evenOccurrences[value]++;
            } else {
                oddOccurrences[value]++;
            }
        }

        PriorityQueue<Occurrence> evenPQ = asPriorityQueue(evenOccurrences);
        PriorityQueue<Occurrence> oddPQ = asPriorityQueue(oddOccurrences);

        final Occurrence topEven = evenPQ.poll();
        final Occurrence topOdd = oddPQ.poll();

        if (topEven == null || topOdd == null) {
            throw new IllegalStateException("top occurrences should not be null");
        }

        if (topEven.number != topOdd.number) {
            return n - topEven.occurrence - topOdd.occurrence;
        } else {
            return countNeedDifferentNumber(n, evenPQ, topEven, oddPQ, topOdd);
        }
    }

    private static int countNeedDifferentNumber(int n, PriorityQueue<Occurrence> evenPQ, Occurrence topEven, PriorityQueue<Occurrence> oddPQ, Occurrence topOdd) {
        final int secondTopEven = getSecondTop(evenPQ);
        final int secondTopOdd = getSecondTop(oddPQ);

        if (secondTopEven > secondTopOdd) {
            return n - secondTopEven - topOdd.occurrence;
        } else {
            return n - secondTopOdd - topEven.occurrence;
        }
    }

    private static int getSecondTop(PriorityQueue<Occurrence> pq) {
        final Occurrence o = pq.peek();
        if (o == null) {
            return 0;
        } else {
            return o.occurrence;
        }
    }

    private static PriorityQueue<Occurrence> asPriorityQueue(int[] occurrences) {
        PriorityQueue<Occurrence> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.occurrence, a.occurrence));

        IntStream.range(0, occurrences.length)
                .filter(i -> occurrences[i] != 0)
                .boxed()
                .map(i -> new Occurrence(i, occurrences[i]))
                .forEach(priorityQueue::add);

        return priorityQueue;
    }

    private static class Occurrence {
        private final int number;
        private final int occurrence;

        private Occurrence(int number, int occurrence) {
            this.number = number;
            this.occurrence = occurrence;
        }
    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final int result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            v.add(sc.nextInt());
        }

        sc.close();
        return new TestCase(n, v);
    }

    private static void output(int result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int n;
        private final List<Integer> v;

        public TestCase(int n, final List<Integer> v) {
            this.n = n;
            this.v = v;
        }
    }
}
