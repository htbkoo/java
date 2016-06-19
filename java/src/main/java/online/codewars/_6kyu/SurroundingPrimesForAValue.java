package online.codewars._6kyu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hey on 20 May 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/surrounding-primes-for-a-value/train/java
 */

/*

We need a function prime_bef_aft() that gives the largest prime below a certain given value n,

befPrime or bef_prime (depending on the language),

and the smallest prime larger than this value,

aftPrime/aft_prime (depending on the language).

The result should be output in a list like the following:

primeBefAft == {befPrime, aftPrime}

If n is a prime number it will give two primes, n will not be included in the result.

Let's see some cases:

primeBefAft(100) --> {97, 101}

primeBefAft(97) --> {89, 101}

primeBefAft(101) --> {97, 103}

Happy coding!!

* */

public class SurroundingPrimesForAValue {
    static class BeforeAfterPrimes {
        public static long[] primeBefAft(long num) {
            long prev = num, next = num;
            //noinspection StatementWithEmptyBody
            while (!naiveIsPrime(next = getPrimeCandidateAfter(next))) ;
            //noinspection StatementWithEmptyBody
            while (!naiveIsPrime(prev = getPrimeCandidateBefore(prev))) ;
            return new long[]{prev, next};
        }

        private static boolean naiveIsPrime(long num) {
            for (int i = 2; i * i <= num; ++i) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        private static long getPrimeCandidateAfter(long i) {
            if (i <= 1) {
                return 2;
            } else if (i == 2) {
                return 3;
            } else if (i == 3) {
                return 5;
            }
            if (isSmallerTwin(i)) {
                return i + 2;
            } else if (isLargerTwin(i)) {
                return i + 4;
            } else if (i % 6 == 0) {
                return i + 1;
            } else {
                return (i/6)*6+5;
            }
        }

        private static long getPrimeCandidateBefore(long i) {
            if (i <= 2) {
                throw new IllegalArgumentException("No prime number before " + i);
            }
            if (i == 3) {
                return 2;
            } else if (i <= 5) {
                return 3;
            } else if (i <= 7) {
                return 5;
            }
            if (isSmallerTwin(i)) {
                return i - 4;
            } else if (isLargerTwin(i)) {
                return i - 2;
            } else if (i % 6 == 0) {
                return i - 1;
            } else {
                return (i/6)*6+1;
            }
        }

        private static boolean isSmallerTwin(long i) {
            return ((i + 1) % 6) == 0;
        }

        private static boolean isLargerTwin(long i) {
            return ((i - 1) % 6) == 0;
        }
    }

    @SuppressWarnings("unused")
    static class FailedAttemptBeforeAfterPrimes {
        public static long[] primeBefAft(long num) {
            // your code
            long prev = 3, prevPrev = 2, next = 5;
            List<Long> sieve = new ArrayList<>();
            sieve.add(prevPrev);
            sieve.add(prev);
            sieve.add(next);
            PrimeNumberGenerator primeNumberGenerator = new ImprovedWith6NRulePrimeNumberGenerator();
            while (next <= num) {
                prevPrev = prev;
                prev = next;
                next = primeNumberGenerator.getNextPrimeWithSieveAfter(prev, sieve);
                sieve.add(next);
            }

            if (((AbstractPrimeNumberGenerator) primeNumberGenerator).isPrime(num, sieve)) {
                return new long[]{prevPrev, next};
            } else {
                return new long[]{prev, next};
            }
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
            public long getNextPrimeWithSieveAfter(final long i, final List<Long> sieve) {
                long next = getNextPrimeCandidateAfter(i);
                while (true) {
                    if (isPrime(next, sieve)) {
                        return next;
                    }
                    next = getNextPrimeCandidateAfter(next);
                }
            }

            abstract protected long getNextPrimeCandidateAfter(final long i);

        }

        private static class ImprovedWith6NRulePrimeNumberGenerator extends AbstractPrimeNumberGenerator {

            @Override
            protected long getNextPrimeCandidateAfter(long i) {
                if (i <= 1) {
                    return 2;
                } else if (i == 2) {
                    return 3;
                } else if (i == 3) {
                    return 5;
                }
                if (isSmallerTwin(i)) {
                    return i + 2;
                }
                return i + 4;
            }

            private boolean isSmallerTwin(long i) {
                return ((i + 1) % 6) == 0;
            }
        }
    }
}
