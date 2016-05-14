package online.codewars._6kyu;

/**
 * Created by Hey on 14 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/find-the-parity-outlier/train/java
 */

/*

You are given an array (which will have a length of at least 3, but could be very large) containing integers. The integers in the array are either entirely odd or entirely even except for a single integer N. Write a method that takes the array as an argument and returns N.

For example:

[2, 4, 0, 100, 4, 11, 2602, 36]

Should return: 11

[160, 3, 1719, 19, 11, 13, -21]

Should return: 160

* */

public class FindOutlier {
    static int find(int[] integers) {
        int numOdd = 0, numEven = 0;
        int lastOdd = 0, lastEven = 0;
        for (int i : integers) {
            if (isEven(i)) {
                ++numEven;
                lastEven = i;
                if (numOdd > 1) {
                    return i;
                }
            } else {
                ++numOdd;
                lastOdd = i;
                if (numEven > 1) {
                    return i;
                }
            }
        }
        if (numEven > 1) {
            return lastOdd;
        }
        return lastEven;
    }

    private static boolean isEven(int i) {
        return i % 2 == 0;
    }
}
