package online.atCoder.beginnerContext120;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Unification {

    public static String process(TestCase testCase) {
        final String S = testCase.S;

        final char[] chars = S.toCharArray();

        int count = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek().equals(c)) {
                    stack.push(c);
                } else {
                    stack.pop();
                    count += 2;
                }
            }
        }

        return String.valueOf(count);
    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final String result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        return new TestCase(S);
    }

    private static IllegalArgumentException unknownN(int N) {
        return new IllegalArgumentException("Unknown N: " + N);
    }

    private static void output(String result) {
        System.out.println(result);
    }

    public static class TestCase {
        final String S;

        public TestCase(String S) {
            this.S = S;
        }
    }
}
