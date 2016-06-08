package online.codewars._5kyu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hey on 21 June 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/prime-factorization/train/java
 */

/*

The prime factorization of a positive integer is a list of the integer's prime factors, together with their multiplicities; the process of determining these factors is called integer factorization. The fundamental theorem of arithmetic says that every positive integer has a single unique prime factorization.

The prime factorization of 24, for instance, is (2^3) * (3^1).

Without using the prime library, write a class called PrimeFactorizer that takes in an integer greater than 1 and has a method called factor which returns a hash where the keys are prime numbers and the values are the multiplicities.

new PrimeFactorizer().factor(24) //should return { 2 => 3, 3 => 1 }

* */

public class PrimeFactorization {
    public static class PrimeFactorizer {

        private PrimeNumberGenerator primeNumberGenerator;

        public java.util.Map<Long, Integer> factor(long n) {
            final Map<Long, Integer> factors = new HashMap<>();
            final List<Long> primes = new ArrayList<>();
            primeNumberGenerator = new NaivePrimeNumberGenerator();

            long prevPrimeFactor = 1;
            while (n > 1) {
                prevPrimeFactor = primeNumberGenerator.getNextPrimeWithSieveAfter(prevPrimeFactor, primes);
                final SingleFactorizeResult factorizeResult = getNextPrimeFactorizeResult(n, prevPrimeFactor);
                n = factorizeResult.resultNumber;
                if (factorizeResult.index > 0) {
                    factors.put(prevPrimeFactor, factorizeResult.index);
                }
            }

            return factors;
        }

        private SingleFactorizeResult getNextPrimeFactorizeResult(long n, long lastPrimeFactor) {
            int count = 0;
            while (n % lastPrimeFactor == 0) {
                ++count;
                n /= lastPrimeFactor;
            }
            return new SingleFactorizeResult(n, count);
        }

        private interface PrimeNumberGenerator {
            long getNextPrimeWithSieveAfter(final long i, final List<Long> sieve);
        }

        private static abstract class AbstractPrimeNumberGenerator implements PrimeNumberGenerator {
            protected final boolean isPrime(long n, final List<Long> primes) {
                long lastPrime;
                for (long i : primes) {
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

            private boolean isPrimeByCheckingFromEndOfSieve(long n, final List<Long> primes) {
                long lastPrime = getLastPrimeOrOneIfEmpty(primes);
                for (long i = lastPrime + 1; i * i < n; ++i) {
                    if (n % i == 0) {
                        return false;
                    }
                }
                return true;
            }

            private long getLastPrimeOrOneIfEmpty(List<Long> primes) {
                long lastPrime = 1;
                if (!primes.isEmpty()) {
                    lastPrime = primes.get(primes.size() - 1);
                }
                return lastPrime;
            }

            @Override
            abstract public long getNextPrimeWithSieveAfter(final long i, final List<Long> sieve);

        }

        private static class ImprovedWith6NRulePrimeNumberGenerator extends AbstractPrimeNumberGenerator {

            @Override
            public long getNextPrimeWithSieveAfter(final long i, final List<Long> sieve) {
                return 0;
            }

        }

        private static class NaivePrimeNumberGenerator extends AbstractPrimeNumberGenerator {

            @Override
            public long getNextPrimeWithSieveAfter(final long i, final List<Long> sieve) {
                long next = i + 1;
                while (true) {
                    if (isPrime(next, sieve)) {
                        return next;
                    }
                    ++next;
                }
            }
        }

        private static class SingleFactorizeResult {
            final long resultNumber;
            final int index;

            public SingleFactorizeResult(long resultNumber, int index) {
                this.resultNumber = resultNumber;
                this.index = index;
            }
        }
    }

    // Too slow, TLE
    public static class SlowPrimeFactorizer {
        private List<Long> primes = new ArrayList<>();

        public java.util.Map<Long, Integer> factor(long n) {
            Map<Long, Integer> factors = new HashMap<>();

            for (long i = 2; (i <= n) && (n > 1); ++i) {
                if (isPrime(i)) {
                    primes.add(i);
                    int count = 0;
                    while (n % i == 0) {
                        ++count;
                        n /= i;
                    }
                    if (count > 0) {
                        factors.put(i, count);
                    }
                }
            }
            return factors;
        }

        private boolean isPrime(long n) {
            for (long i : primes) {
                if ((i * i) > n) {
                    return true;
                }
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
