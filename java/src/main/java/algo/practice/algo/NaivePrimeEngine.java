package algo.practice.algo;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Hey on 20/9/15
 */
public class NaivePrimeEngine implements PrimeNumberFinderEngine {
    private long steps;

    @Override
    public List<Integer> listPrimeBetween(int start, int end) {
        List<Integer> primes = Lists.newArrayList();
        for (int i = start; i <= end; i++) {
            steps++;

            if (checkIsPrime(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

    @Override
    public boolean checkIsPrime(int n) {
        for (int i = 2; i < n; i++) {
            steps++;

            if (n % i == 0)
                return false;
        }
        return true;
    }

    @Override
    public long getSteps() {
        return steps;
    }
}
