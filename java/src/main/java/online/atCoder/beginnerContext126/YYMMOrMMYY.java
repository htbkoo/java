package online.atCoder.beginnerContext126;

import java.util.Scanner;

public class YYMMOrMMYY {

    private static final String AMBIGUOUS = "AMBIGUOUS";
    private static final String MMYY = "MMYY";
    private static final String NA = "NA";
    private static final String YYMM = "YYMM";

    public static String process(String S) {
        String firstPart = S.substring(0, 2);
        String secondPart = S.substring(2);

        boolean isFirstPartValid = isValidMonth(firstPart);
        boolean isSecondPartValid = isValidMonth(secondPart);
        if (isFirstPartValid && isSecondPartValid) {
            return AMBIGUOUS;
        } else if (isFirstPartValid) {
            return MMYY;
        } else if (isSecondPartValid) {
            return YYMM;
        } else {
            return NA;
        }
    }

    private static boolean isValidMonth(String part) {
        try {
            Integer i = Integer.valueOf(part);
            return i > 0 && i <= 12;
        } catch (Exception e) {
            return false;
        }
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
