package online.codewars._5kyu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hey on 21 June 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/prime-factorization/train/java
 */

/*

Given a positive number n > 0 (Javascript n >= 0) find the prime factor decomposition of n. The result will be a string with the following form :

 "(p1**n1)(p2**n2)...(pk**nk)"

with the p(i) in increasing order and n(i) empty if n(i) is 1.

Example: n = 86240 should return "(2**5)(5)(7**2)(11)"

* */

public class PrimesInNumbers {
    public static class PrimeDecomp {
        private static PrimeNumberGenerator primeNumberGenerator;

        public static String factors(int n) {
            StringBuilder stringBuilder = new StringBuilder();

            final List<Integer> primes = new ArrayList<>();
            primeNumberGenerator = new ImprovedWith6NRulePrimeNumberGenerator();

            int prevPrimeFactor = 1;
            while (n > 1) {
                prevPrimeFactor = primeNumberGenerator.getNextPrimeWithSieveAfter(prevPrimeFactor, primes);
                final SingleFactorizeResult factorizeResult = getNextPrimeFactorizeResult(n, prevPrimeFactor);
                n = factorizeResult.resultNumber;
                if (factorizeResult.index > 0) {
                    stringBuilder.append(getStringFragment(prevPrimeFactor, factorizeResult.index));
                }
            }

            return stringBuilder.toString();
        }

        private static String getStringFragment(int resultNumber, int index) {
            if (index==1){
                return String.format("(%d)",resultNumber);
            }else{
                return String.format("(%d**%d)",resultNumber,index);
            }
        }

        private static SingleFactorizeResult getNextPrimeFactorizeResult(int n, int lastPrimeFactor) {
            int count = 0;
            while (n % lastPrimeFactor == 0) {
                ++count;
                n /= lastPrimeFactor;
            }
            return new SingleFactorizeResult(n, count);
        }

        private interface PrimeNumberGenerator {
            int getNextPrimeWithSieveAfter(final int i, final List<Integer> sieve);
        }

        private static abstract class AbstractPrimeNumberGenerator implements PrimeNumberGenerator {
            protected final boolean isPrime(int n, final List<Integer> primes) {
                int lastPrime;
                for (int i : primes) {
                    lastPrime = i;
                    if (n % i == 0) {
                        return false;
                    }
                    if ((lastPrime * lastPrime) >= n) {
                        return true;
                    }
                }
                return isPrimeByCheckingFromEndOfSieve(n, new ArrayList<>(primes));
            }

            private boolean isPrimeByCheckingFromEndOfSieve(int n, final List<Integer> primes) {
                int lastPrime = getLastPrimeOrOneIfEmpty(primes);
                for (int i = lastPrime + 1; i * i < n; ++i) {
                    if (n % i == 0) {
                        return false;
                    }
                }
                return true;
            }

            private int getLastPrimeOrOneIfEmpty(List<Integer> primes) {
                int lastPrime = 1;
                if (!primes.isEmpty()) {
                    lastPrime = primes.get(primes.size() - 1);
                }
                return lastPrime;
            }

            @Override
            public int getNextPrimeWithSieveAfter(final int i, final List<Integer> sieve) {
                int next = getNextPrimeCandidateAfter(i);
                while (true) {
                    if (isPrime(next, sieve)) {
                        return next;
                    }
                    next = getNextPrimeCandidateAfter(next);
                }
            }

            abstract protected int getNextPrimeCandidateAfter(final int i);

        }

        private static class ImprovedWith6NRulePrimeNumberGenerator extends AbstractPrimeNumberGenerator {

            @SuppressWarnings("Duplicates")
            @Override
            protected int getNextPrimeCandidateAfter(int i) {
                if (i <= 1) {
                    return 2;
                } else if (i == 2) {
                    return 3;
                } else if (i == 3) {
                    return 5;
                }
                if (isSmallerTwin(i)){
                    return i+2;
                }
                return i+4;
            }

            private boolean isSmallerTwin(int i) {
                return ((i + 1) % 6) == 0;
            }
        }

        private static class SingleFactorizeResult {
            final int resultNumber;
            final int index;

            public SingleFactorizeResult(int resultNumber, int index) {
                this.resultNumber = resultNumber;
                this.index = index;
            }
        }
    }

}
