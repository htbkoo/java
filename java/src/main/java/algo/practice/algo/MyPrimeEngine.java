package algo.practice.algo;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Hey on 20/9/15
 */
public class MyPrimeEngine implements PrimeNumberFinderEngine {
    private long steps;

    //    Due to the poorly designed contract in the interface, it is inevitable but to make the variable a field
//    instead of passing as parameter.
    private List<Integer> primes;

//    My first attempt, may actually suffer from poor performance
    public List<Integer> listPrimeBetweenByFirstAttempt(int start, int end) {
        primes = Lists.newArrayList();
        for (int i = start; i <= end; i++) {
            steps++;

            if (checkIsPrimeByFirstAttempt(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

    private boolean checkIsPrimeByFirstAttempt(int n) {
        for (Integer i:primes) {
            steps++;
            if (n % i == 0)
                return false;
        }
        return true;
    }

    @Override
    public List<Integer> listPrimeBetween(int start, int end) {
        primes = Lists.newArrayList();
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
        for (Integer i:primes) {
            steps++;

            if (i>(int) (Math.ceil(Math.sqrt(n)))){
                break;
            }

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
