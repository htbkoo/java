package online.atCoder.beginnerContext119;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DigitalGifts {
    private static final BigDecimal BTC_TO_JPY_CONVERT_RATIO = new BigDecimal("380000.0");

    public static String process(TestCase testCase) {
        int N = testCase.N;
        BigDecimal sum = BigDecimal.ZERO;

        final List<BigDecimal> x = testCase.x;
        final List<String> u = testCase.u;
        for (int i = 0; i < N; ++i) {
            sum = sum.add(valueInJPY(x, u, i));
        }

        return sum.toPlainString();
    }

    private static BigDecimal valueInJPY(List<BigDecimal> x, List<String> u, int i) {
        final String currency = u.get(i);
        final BigDecimal value = x.get(i);
        return Currency.fromString(currency).asJPY(value);
    }

    private enum Currency {
        JPY(BigDecimal.ONE), BTC(BTC_TO_JPY_CONVERT_RATIO);

        private final BigDecimal toJpyConvertRatio;

        Currency(BigDecimal toJpyConvertRatio) {
            this.toJpyConvertRatio = toJpyConvertRatio;
        }

        public BigDecimal asJPY(BigDecimal value) {
            return value.multiply(toJpyConvertRatio);
        }

        public static Currency fromString(String possibleCurrency) {
            return Arrays.stream(values())
                    .filter(currency -> currency.name().equals(possibleCurrency))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown Currency: " + possibleCurrency));
        }
    }

    // Util func

    public static void main(String[] args) {
        TestCase testCase = readFromInput();

        final String result = process(testCase);

        output(result);
    }

    private static TestCase readFromInput() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<BigDecimal> x = new ArrayList<>();
        List<String> u = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            x.add(new BigDecimal(sc.next()));
            u.add(sc.next());
        }

        sc.close();
        return new TestCase(N, x, u);
    }

    private static void output(String result) {
        System.out.println(result);
    }

    public static class TestCase {
        final int N;
        final List<BigDecimal> x;
        final List<String> u;

        public TestCase(int N, final List<BigDecimal> x, final List<String> u) {
            this.N = N;
            this.x = x;
            this.u = u;
        }
    }
}
