package online.atCoder.yahooProgrammingContest2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class XXOR {
    private static final int MAX_NUM_DIGIT_IN_BINARY = 40; // 10^12 < 2^40

    public static long process(TestCase testCase) {
        final long N = testCase.N;
        final long K = testCase.K;
        final List<Long> A = testCase.A;

        if (K == 0) {
            return A.stream().mapToLong(i -> i).sum();
        } else {
            return maxSumAfterXor(A, K);
        }
    }

    private static long maxSumAfterXor(List<Long> A, long K) {
        int[][] allDigits = covertToDigitsMatrix(A);
        final int N = A.size();

        final int numDigitToCheck = findNumDigitToCheck(K);
        final int[] kInBinary = Long.toBinaryString(K).chars().map(Character::getNumericValue).toArray();
        final int[] paddedK = new int[MAX_NUM_DIGIT_IN_BINARY];
        System.arraycopy(kInBinary, 0, paddedK, MAX_NUM_DIGIT_IN_BINARY - kInBinary.length, kInBinary.length);
        final int numDigits = kInBinary.length;

        long sum = 0;
        long base = 1L << MAX_NUM_DIGIT_IN_BINARY - 1;
        for (int j = 0; j < MAX_NUM_DIGIT_IN_BINARY; ++j) {
            int count = countOnes(allDigits, j);
            boolean isWithinK = paddedK[j] == 1;
            if (isWithinK) {
                int flippedCount = N - count;
                count = Math.max(count, flippedCount);
            }
            sum += count * base;
            base = base >> 1;
        }

//        for (int j = numDigits - 1; j >= 0; --j) {
//            final int rightAlignedIndex = MAX_NUM_DIGIT_IN_BINARY - numDigits + j;
//            final char digit = digits.charAt(j);
//            allDigits[i][rightAlignedIndex] = Character.getNumericValue(digit);
//        }

        return sum;
    }

    private static int countOnes(int[][] allDigits, int j) {
        int count = 0;
        for (int[] digits : allDigits) {
            count += digits[j];
        }
        return count;
    }

    private static int[][] covertToDigitsMatrix(List<Long> A) {
        int[][] allDigits = new int[A.size()][MAX_NUM_DIGIT_IN_BINARY];
        for (int i = 0; i < A.size(); ++i) {
            String digits = Long.toBinaryString(A.get(i));
            final int numDigits = digits.length();
            for (int j = numDigits - 1; j >= 0; --j) {
                final int rightAlignedIndex = MAX_NUM_DIGIT_IN_BINARY - numDigits + j;
                final char digit = digits.charAt(j);
                allDigits[i][rightAlignedIndex] = Character.getNumericValue(digit);
            }
        }
        return allDigits;
    }

    private static int[][] covertToDigitsMatrixStream(List<Long> A) {
        int[][] allDigits = new int[A.size()][MAX_NUM_DIGIT_IN_BINARY];
        final List<List<Integer>> digitsLists = A.stream()
                .map(Long::toBinaryString)
                .map(String::chars)
                .map(stream -> stream.map(Character::getNumericValue).boxed().collect(Collectors.toList()))
//                .map(stream -> stream.map(i -> i - '0').boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
        for (int i = 0; i < digitsLists.size(); ++i) {
            final List<Integer> digits = digitsLists.get(i);
            final int numDigits = digits.size();
            for (int j = numDigits - 1; j >= 0; --j) {
                final int rightAlignedIndex = MAX_NUM_DIGIT_IN_BINARY - numDigits + j;
                allDigits[i][rightAlignedIndex] = digits.get(j);
            }
        }
        return allDigits;
    }

    private static int findNumDigitToCheck(long K) {
        return Long.toBinaryString(K).length();
    }

    private static long fromBinaryString(String binary) {
        return Long.valueOf(binary, 2);
    }

    // util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final long result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long K = sc.nextLong();
        List<Long> A = new ArrayList<>();
        for (long i = 0; i < N; ++i) {
            A.add(sc.nextLong());
        }

        sc.close();
        return new TestCase(N, K, A);
    }

    private static void output(long result) {
        System.out.println(result);
    }

    public static class TestCase {
        final long N;
        final long K;
        final List<Long> A;

        public TestCase(long N, long K, List<Long> A) {
            this.N = N;
            this.K = K;
            this.A = A;
        }
    }
}
