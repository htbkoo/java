package online.atCoder.beginnerContext124;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GreatOceanView {

    public static String process(int N, List<Integer> H) {
        int max = H.get(0);
        int sum = 0;
        for (int h : H) {
            if (h >= max) {
                sum++;
                max = Math.max(max, h);
            }
        }
        return String.valueOf(sum);
    }

    // Util func

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer> H = IntStream.range(0, N).map(i -> sc.nextInt()).boxed().collect(Collectors.toList());

        final String result = process(N, H);

        output(result);
    }

    private static void output(String result) {
        System.out.println(result);
    }
}
