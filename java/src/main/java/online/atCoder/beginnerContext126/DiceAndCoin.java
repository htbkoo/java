package online.atCoder.beginnerContext126;

import java.util.Scanner;

public class DiceAndCoin {

    private static final double LOG_OF_2 = Math.log(2);
    private static final double PROBABILITY_HEAD = 0.5;

    public static String process(int N, int K) {
        double sum = 0;
        for (int i = 1; i <= Math.min(N, K); ++i) {
            double numTimesNeeded = Math.ceil(Math.log((double) K / (double) i) / LOG_OF_2);
            sum += Math.pow(PROBABILITY_HEAD, numTimesNeeded) / (double) N;
        }
        sum += (double) Math.max(0, N - K) / (double) (N);
        return String.valueOf(sum);
    }

    // Util func

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        final String result = process(N, K);

        output(result);
    }

    private static void output(String result) {
        System.out.println(result);
    }
}
