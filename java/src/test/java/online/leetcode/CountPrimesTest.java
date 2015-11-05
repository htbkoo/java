package online.leetcode;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 25/10/15
 */
@RunWith(Parameterized.class)
public class CountPrimesTest {
    @Parameters
    public static Collection<Pair<Integer, Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (0, 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1, 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2, 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (3, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (4, 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1000, 168)
                }, new Pair[]{
                        new ImmutablePair<>
                                (38, 12)
                }, new Pair[]{
                        new ImmutablePair<>
                                (43762, 4557)
                });
    }

    private int fInput;
    private int fExpected;

    public CountPrimesTest(Pair<Integer, Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldCountPrimes() {
        assertEquals(fExpected, new CountPrimes().countPrimes(fInput));
    }
}