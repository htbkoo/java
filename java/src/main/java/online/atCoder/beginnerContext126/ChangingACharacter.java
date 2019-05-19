package online.atCoder.beginnerContext126;

import java.util.Scanner;

public class ChangingACharacter {

    public static String process(int N, int K, String S) {
        return S.substring(0, K - 1) + S.substring(K - 1, K).toLowerCase() + S.substring(K);
    }

    // Util func

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        String S = sc.next();

        final String result = process(N, K, S);

        output(result);
    }

    private static void output(String result) {
        System.out.println(result);
    }
}
