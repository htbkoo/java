package online.atCoder.beginnerContext123;

import java.util.Scanner;

public class FiveAntennas {

    private static final String YES = "Yay!";
    private static final String NO = ":(";

    public static String process(int a, int b, int c, int d, int e, int k) {
        return ((e - a) <= k) ? YES : NO;
    }

    // Util func

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int k = sc.nextInt();

        final String result = process(a, b, c, d, e, k);

        output(result);
    }

    private static void output(String result) {
        System.out.println(result);
    }
}
