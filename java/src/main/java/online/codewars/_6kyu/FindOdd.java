package online.codewars._6kyu;

import java.util.Arrays;

/**
 * Created by Hey on 15 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/find-the-odd-int/train/java
 */

/*

Given an array, find the int that appears an odd number of times.

There will always be only one integer that appears an odd number of times.

* */

public class FindOdd {
    public static int findIt(int[] A) {
        return Arrays.stream(A).reduce((a, b) -> a ^ b).getAsInt();
    }
}
