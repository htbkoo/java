package online.leetcode;

import online.leetcode.infrastructure.LeetCodeUnitTestInfrastructure;
import online.leetcode.infrastructure.LeetCodeUnitTestInfrastructureForOneInput;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Hey on 13/12/15
 */
@RunWith(Parameterized.class)
public class MaximumProductSubarrayTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameters
    public static Collection<Pair<Integer[], Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 3, -2, 4}
                                        , 6)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, -2, 1, 3, 3}
                                        , 36)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 17, -23, 3, -3, 1, 23}
                                        , 80937)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 17, -23, 3, -3, 1, -23}
                                        , 3519)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 17, -23, 3, -3, 1, -23, 26}
                                        , 5382)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-1, 17, -18, 19, 3, -3, 1, -23}
                                        , 1203498)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 17, 0, -23, 3, -3, 10, 0, -23, 26}
                                        , 2070)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-1, 17, -18, 0, 19, 3, -3, 0, 1, -23}
                                        , 306)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-1}
                                        , -1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-1, 0}
                                        , 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-1, -1, -1, 0}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 0}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, -1}
                                        , 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 1}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, 0, 1}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, 0, 0}
                                        , 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, 0, -1}
                                        , 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-1, -1, -2, -2, -1, -1}
                                        , 4)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-1, -1, -2, 1, -2, -1, -1}
                                        , 4)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 1, 1, 1, -2, 1, 1}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, 1, 1}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 1, -2}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, -2, 1}
                                        , 1)
                });
    }

    public MaximumProductSubarrayTest(Pair<Integer[], Integer> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createLeetCodeUnitTestPairInfrastructureWithListOfInteger(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldFindMaximumProductSubarray() {
        leetCodeUnitTestInfrastructure.test();
    }
}