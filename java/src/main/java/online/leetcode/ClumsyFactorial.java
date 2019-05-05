package online.leetcode;

/*

https://leetcode.com/problems/clumsy-factorial/

Normally, the factorial of a positive integer n is the product of all positive integers less than or equal to n.  For example, factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1.

We instead make a clumsy factorial: using the integers in decreasing order, we swap out the multiply operations for a fixed rotation of operations: multiply (*), divide (/), add (+) and subtract (-) in this order.

For example, clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1.  However, these operations are still applied using the usual order of operations of arithmetic: we do all multiplication and division steps before any addition or subtraction steps, and multiplication and division steps are processed left to right.

Additionally, the division that we use is floor division such that 10 * 9 / 8 equals 11.  This guarantees the result is an integer.

Implement the clumsy function as defined above: given an integer N, it returns the clumsy factorial of N.



Example 1:

Input: 4
Output: 7
Explanation: 7 = 4 * 3 / 2 + 1

Example 2:

Input: 10
Output: 12
Explanation: 12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1



Note:

    1 <= N <= 10000
    -2^31 <= answer <= 2^31 - 1  (The answer is guaranteed to fit within a 32-bit integer.)

*/

public class ClumsyFactorial {
    static class Solution {
        public int clumsy(int N) {
            return (int) (firstPart(N) + plusParts(N - 3) - minusParts(N - 4));
        }

        private long firstPart(int n) {
            if (n <= 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            } else {
                return n * (n - 1) / (n - 2);
            }
        }

        private long plusParts(int n) {
            long result = 0;
            while (n > 0) {
                result += n;
                n -= 4;
            }
            return result;
        }

        private long minusParts(int n) {
            long result = 0;
            while (n > 0) {
                result += firstPart(n);
                n -= 4;
            }
            return result;
        }
    }
}
