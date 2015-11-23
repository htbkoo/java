package online.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hey on 22/11/15
 */

/*

https://leetcode.com/problems/divide-two-integers/

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

Subscribe to see which companies asked this question


*/

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int result = 0;
        if (dividend == -2147483648) {
            if (divisor == 1) {
                return dividend;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor == -2147483648) {
                return 1;
            } else {
                ++result;
                if (divisor > 0) {
                    dividend += divisor;
                } else {
                    dividend -= divisor;
                }
            }
        } else {
            if (divisor == -2147483648) {
                return 0;
            }
        }

        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }
        int sign = 1;
        if (dividend < 0) {
            sign = -sign;
            dividend = -dividend;
        }
        if (divisor < 0) {
            sign = -sign;
            divisor = -divisor;
        }

        List<Integer> divisors = new ArrayList<>();
        List<Integer> addResults = new ArrayList<>();
        divisors.add(divisor);
        addResults.add(1);

        int pointer = 0;
        Integer curDivisor = divisors.get(pointer);
        while ((dividend >= curDivisor)) {
            curDivisor = divisors.get(pointer);
            if ((curDivisor + curDivisor) < 0) {
                break;
            }
            final Integer curResult = addResults.get(pointer);
            divisors.add(curDivisor + curDivisor);
            addResults.add(curResult + curResult);
            ++pointer;

        }

        while (pointer >= 0) {
            curDivisor = divisors.get(pointer);
            while (dividend >= curDivisor) {
                dividend -= curDivisor;
                result += addResults.get(pointer);
            }
            --pointer;
        }

        if (sign == -1) {
            return -result;
        }
        return result;
    }

    private class LinearSubtractionTooSlow {
        public int divide(int dividend, int divisor) {
            if (divisor == 0) {
                throw new ArithmeticException("/ by zero");
            }
            int result = 0;
            if (dividend == -2147483648) {
                if (divisor == -1) {
                    return Integer.MAX_VALUE;
                } else {
                    ++result;
                    if (divisor > 0) {
                        dividend += divisor;
                    } else {
                        dividend -= divisor;
                    }
                }
            }

            if (divisor == 1) {
                return dividend;
            }
            if (divisor == -1) {
                return -dividend;
            }
            int sign = 1;
            if (dividend < 0) {
                sign = -sign;
                dividend = -dividend;
            }
            if (divisor < 0) {
                sign = -sign;
                divisor = -divisor;
            }
            while (dividend >= divisor) {
                dividend -= divisor;
                ++result;
            }
            if (sign == -1) {
                return -result;
            }
            return result;
        }
    }
}
