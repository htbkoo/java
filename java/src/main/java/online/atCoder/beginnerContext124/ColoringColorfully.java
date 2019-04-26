package online.atCoder.beginnerContext124;

import java.util.Scanner;

public class ColoringColorfully {
    private static final int ZERO = 48;

    public static String process(String S) {

        int diffStartWithZero = diffStartsWith(0, S);
        int diffStartWithOne = diffStartsWith(1, S);

        return String.valueOf(Math.min(diffStartWithZero, diffStartWithOne));
    }

    private static int diffStartsWith(int start, String S) {
        int diff = 0;
        for (int i = 0, length = S.length(); i < length; ++i) {
            if (S.codePointAt(i) - ZERO != start) {
                diff++;
            }
            start = (start + 1) % 2;
        }

        return diff;
    }

    // Util func

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        final String result = process(S);

        output(result);
    }

    private static void output(String result) {
        System.out.println(result);
    }
}
