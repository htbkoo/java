package online.leetcode;

import online.leetcode.infrastructure.LeetCodeUnitTestInfrastructure;
import online.leetcode.infrastructure.LeetCodeUnitTestInfrastructureForOneInput;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Hey on 26/1/16
 */
@RunWith(Parameterized.class)
public class PerfectSquaresTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameterized.Parameters
    public static Collection<Pair<Integer, Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (1
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2
                                        , 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                (3
                                        , 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (12
                                        , 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (13
                                        , 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                (4
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1024
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (65536
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (987
                                        , 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (80359
                                        , 4)
                });
    }

    public PerfectSquaresTest(Pair<Integer, Integer> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createLeetCodeUnitTestPairInfrastructureWithInput(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldCheckIsPowerOfTwo() {
        leetCodeUnitTestInfrastructure.test();
    }

}