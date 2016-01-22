package online.leetcode;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hey on 22/11/15
 */

/*

https://leetcode.com/problems/powx-n/

Implement pow(x, n).

Subscribe to see which companies asked this question

*/

public class PowXN {
    public double myPow(double x, int n) {
        if (x == 0.0) {
            return 0.0;
        }

        int pointer = 0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

//        note the Integer.MAX_VALUE is 32bit thus 33 is more than enought, 1000 is just in case and is randomly picked
        double[] map = new double[1000];
        int cur = 1;
        map[pointer] = x;
        while (2L * (long) cur <= (long) n) {
            final double last = map[pointer];
            map[pointer+1] = last * last;
            cur *= 2;
            ++pointer;
        }

        double result = 1.0;
        while (n > 0) {
            if (n >= cur) {
                result *= map[pointer];
                n -= cur;
            }
            --pointer;
            cur /= 2;
        }
        return result;
    }

    private class SuccessUseHasMapSlow {
        public double myPow(double x, int n) {
            if (x == 0.0) {
                return 0.0;
            }

            Map<Integer, Double> map = new HashMap<>();

            if (n < 0) {
                x = 1 / x;
                n = -n;
            }

            int cur = 1;
            map.put(cur, x);
            while (2L * (long) cur <= (long) n) {
                final double last = map.get(cur);
                map.put(cur * 2, last * last);
                cur *= 2;
            }

            double result = 1.0;
            while (n > 0) {
                if (n >= cur) {
                    result *= map.get(cur);
                    n -= cur;
                }
                cur /= 2;
            }
            return result;
        }
    }

    private class UseBigDecimal {
        public double myPow(double x, int n) {
            if (x == 0.0) {
                return 0.0;
            }

            BigDecimal bdx = new BigDecimal(x);
            Map<Integer, BigDecimal> map = new HashMap<>();

            int cur = 1;
            map.put(cur, bdx);
            while (2L * (long) cur <= (long) n) {
                final BigDecimal last = map.get(cur);
                map.put(cur * 2, last.multiply(last));
                cur *= 2;
            }

            BigDecimal result = new BigDecimal("1");
            while (n > 0) {
                if (n >= cur) {
                    result = result.multiply(map.get(cur));
                    n -= cur;
                }
                cur /= 2;
            }
            return result.doubleValue();
        }
    }
}
