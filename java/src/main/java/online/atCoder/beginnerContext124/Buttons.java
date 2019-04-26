package online.atCoder.beginnerContext124;

import java.util.Scanner;

public class Buttons {

    public static String process(int A, int B) {
        int aTwice = A + A - 1;
        int bTwice = B + B - 1;
        int both = A + B;
        return String.valueOf(Math.max(aTwice, Math.max(bTwice, both)));
    }

    // Util func

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        final String result = process(A, B);

        output(result);
    }

    private static void output(String result) {
        System.out.println(result);
    }
}
