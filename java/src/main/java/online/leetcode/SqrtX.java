package online.leetcode;

/**
 * Created by Hey on 22/11/15
 */

/*

https://leetcode.com/problems/sqrtx/

Implement int sqrt(int x).

Compute and return the square root of x.

Subscribe to see which companies asked this question

*/

public class SqrtX {
    public int mySqrt(int x) {
//        According to OJ.
        if (x<0){
            return x;
        }

        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int cur = 1;
        int last = 1;
//        while (cur * cur < x) {
//        Cheating
        while ((long)cur * (long)cur < (long)x) {
            last = cur;
            cur = cur * 2;
        }

        //        Cheating
//        if (cur * cur == x) {
        if ((long)cur * (long)cur == (long)x) {
            return cur;
        }

        while (cur - last > 1) {
            int mid = last + (cur - last) / 2;
            final long sq = (long)mid * (long)mid;
            if (sq == (long)x) {
                return mid;
            } else if (sq < (long)x) {
                last = mid;
            } else {
                cur = mid;
            }

        }

//        if (cur * cur > x) {
        if ((long)cur * (long)cur > (long)x) {
            return last;
        }
        return cur;
    }
}
