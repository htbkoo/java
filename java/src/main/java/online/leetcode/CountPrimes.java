package online.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hey on 25/10/15
 */

/*

https://leetcode.com/problems/count-primes/

Count the number of prime numbers less than a non-negative number, n.

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
*/

public class CountPrimes {
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (checkIsPrime(i, primes)) {
                primes.add(i);
            }
        }
        return primes.size();
    }

    private boolean checkIsPrime(int n, List<Integer> primesFound) {
        Integer N = n;
        for (Integer i : primesFound) {
            if (i * i > N) {
                break;
            }
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    private class FirstAttempt{
        public int countPrimes(int n) {
            int primes = 0;
            for (int i = 2; i < n; ++i) {

                if (checkIsPrime(i)) {
                    ++primes;
                }
            }

            return primes;
        }

        private boolean checkIsPrime(int n) {
            for (int i = 2; i < n && i <= (int) (Math.ceil(Math.sqrt(n))); i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        }
    }

}
