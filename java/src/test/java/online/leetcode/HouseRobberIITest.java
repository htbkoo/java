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
 * Created by Hey on 4/1/16
 */
@RunWith(Parameterized.class)
public class HouseRobberIITest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameters
    public static Collection<Pair<Integer[], Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{}
                                        , 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 2, 3, 4}
                                        , 6)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 2, 3, 4, 5}
                                        , 8)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 2, 3, 4, 1}
                                        , 6)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 1}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 0}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 0, 1}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 1, 0, 1}
                                        , 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 1, 0}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{3, 1, 1, 3}
                                        , 4)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 2}
                                        , 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 3, 0, 3, 1}
                                        , 6)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 3, 6, 3, 1}
                                        , 7)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 3, 3, 1}
                                        , 4)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{10}
                                        , 10)
                });
    }

    public HouseRobberIITest(Pair<Integer[], Integer> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                <Integer[], Integer>createLeetCodeUnitTestPairInfrastructureWithListOfInteger(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldFindMaxAmountForRob() {
        leetCodeUnitTestInfrastructure.test();
    }
}