package algo.practice.algo;

import java.util.List;

/**
 * Created by Hey on 19/9/15
 */
public interface PrimeNumberFinderEngine {
    List<Integer> listPrimeBetween(int start, int end);

    boolean checkIsPrime(int n);

    long getSteps();

}
