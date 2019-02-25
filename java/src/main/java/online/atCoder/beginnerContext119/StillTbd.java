package online.atCoder.beginnerContext119;

import java.util.Scanner;

public class StillTbd {
    private static final String HEISEI = "Heisei";
    private static final String TBD = "TBD";

    public static String process(TestCase testCase) {
        final String S = testCase.S;
        final String[] parts = S.split("/");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        if (isTbd(year, month, day)) {
            return TBD;
        } else {
            return HEISEI;
        }
    }

    private static boolean isTbd(int year, int month, int day) {
        final boolean isAfterYear = year > 2019;
        final boolean isAfterMonth = year == 2019 && month > 4;
        final boolean isAfterDay = year == 2019 && month == 4 && day > 30;
        return isAfterYear || isAfterMonth || isAfterDay;
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

        sc.close();
        return new TestCase(S);
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
