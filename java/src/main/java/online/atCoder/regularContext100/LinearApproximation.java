package online.atCoder.regularContext100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinearApproximation {
    public static int process(TestCase testCase) {
        int N = testCase.N;
        List<Integer> A = testCase.A;

        List<Integer> differences = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();
        int zeroCount = 0;

        for (int i = 0; i < N; ++i) {
            int target = (i + 1);
            final int diff = target - A.get(i);
            differences.add(diff);

            if (diff == 0) {
                zeroCount++;
            } else if (diff < 0) {
                negative.add(diff);
            } else {
                positive.add(diff);
            }
        }

        differences.sort(Integer::compareTo);

        int mid = N / 2;
        final int midDiff = differences.get(mid);
        final int midPlusOneDiff = differences.get(mid + 1);
        if (noChangeNeeded(N, positive, negative, midDiff, midPlusOneDiff)) {
            return getAbsSum(negative) + getAbsSum(positive);
        } else {
            return getResult(zeroCount, negative, positive, midDiff);
        }
    }

    private static int getResult(int zeroCount, List<Integer> negative, List<Integer> positive, int midDiff) {
        int negativeSum = Math.abs(sum(negative) - midDiff * negative.size());
        int positiveSum = Math.abs(sum(positive) - midDiff * positive.size());
        int zeroSum = Math.abs(zeroCount * midDiff);
        return negativeSum + zeroSum + positiveSum;
    }

    private static boolean noChangeNeeded(int N, List<Integer> positive, List<Integer> negative, int midDiff, int midPlusOneDiff) {
        final boolean isMidDiffZero = midDiff == 0;
        final boolean isForEvenMidPlusOneDiffZero = (N % 2 == 0) && midPlusOneDiff == 0;
        final boolean isSameNumPosAndNeg = positive.size() == negative.size();

        return isMidDiffZero || isForEvenMidPlusOneDiffZero || isSameNumPosAndNeg;
    }

    private static int getAbsSum(List<Integer> list) {
        return Math.abs(sum(list));
    }

    private static int sum(List<Integer> list) {
        return list.stream().mapToInt(i -> i).sum();
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

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            A.add(sc.nextInt());
        }

        sc.close();
        return new TestCase(N, A);
    }

    private static void output(int result) {
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
