package online.atCoder.beginnerContext116;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CollatzProblem {
    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final int result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();

        sc.close();
        return new TestCase(s);
    }

    public static int process(TestCase testCase) {
        int s = testCase.s;
        Set<Integer> appeared = new HashSet<>();
        int count = 1;

        while (!appeared.contains(s)) {
            count++;
            appeared.add(s);

            boolean isOdd = (s % 2) != 0;
            if (isOdd) {
                s = handleOdd(s);
            } else {
                s = handleEven(s);
            }
        }
        return count;
    }

    private static int handleOdd(int s) {
        return 3 * s + 1;
    }

    private static int handleEven(int s) {
        return s / 2;
    }

    private static void output(int result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int s;

        public TestCase(int s) {
            this.s = s;
        }
    }
}
