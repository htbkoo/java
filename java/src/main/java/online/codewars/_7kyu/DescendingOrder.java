package online.codewars._7kyu;

/**
 * Created by Hey on 12 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/5467e4d82edf8bbf40000155/train/java
 * <p>
 * <p>
 * Your task is to make a function that can take any non-negative integer as a argument and
 * return it with it's digits in descending order. Descending order means that you take the highest digit and
 * place the next highest digit immediately after it.
 * Examples:
 * <p>
 * Input: 145263 Output: 654321
 * <p>
 * Input: 1254859723 Output: 9875543221
 */
public class DescendingOrder {
    public static int sortDesc(final int num) {
        //Your code
        //        Radix sort
        final int[] radix = new int[10];
        int temp = num;
        while (temp >= 10) {
            ++radix[temp % 10];
            temp /= 10;
        }
        ++radix[temp % 10];
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 9; i >= 0; --i) {
            stringBuilder.append(new String(new char[radix[i]]).replace("\0", String.valueOf(i)));
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}