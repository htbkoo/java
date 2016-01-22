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
public class MaximumSubarrayTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameters
    public static Collection<Pair<Integer[], Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}
                                        , 6)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, -2, 1, 3, 3}
                                        , 7)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 17, -23, 3, -3, 1, 23}
                                        , 24)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 17, -23, 3, -3, 1, -23}
                                        , 18)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 17, -23, 3, -3, 1, -23, 26}
                                        , 26)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-1, 17, -18, 19, 3, -3, 1, -23}
                                        , 22)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-1}
                                        , -1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-1, -1, -2, -2, -1, -1}
                                        , -1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-1, -1, -2, 1, -2, -1, -1}
                                        , 1)
                });
    }

    public MaximumSubarrayTest(Pair<Integer[], Integer> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createLeetCodeUnitTestPairInfrastructureWithListOfInteger(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldFindMaxSubArray() {
        leetCodeUnitTestInfrastructure.test();
    }
}