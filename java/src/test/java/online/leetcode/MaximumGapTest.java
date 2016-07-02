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
 * Created by Hey on 1 Jul 2016
 */

@RunWith(Parameterized.class)
public class MaximumGapTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameterized.Parameters
    public static Collection<Pair<Integer[], Integer>[]> data() {
        //noinspection unchecked
        return Arrays.asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{}
                                        , 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1}
                                        , 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 3, 8, 12, 4, 6, 9, 22}
                                        , 10)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 1, 2, 3, 4, 5, 10}
                                        , 5)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 1, 2, 3, 4, 5, 14}
                                        , 9)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 1, 2, 3, 4, 5, 13}
                                        , 8)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 1, 2, 3, 4, 5, 15}
                                        , 10)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{4, 2, 3, 1, 5, 0, 99999}
                                        , 99994)
                }
                , new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, Integer.MAX_VALUE}
                                        , Integer.MAX_VALUE)
                }
                , new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 99999999}
                                        , 99999997)
                }
                , new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740}
                                        , 2901)
                }
        );
    }

    public MaximumGapTest(Pair<Integer[], Integer> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createLeetCodeUnitTestPairInfrastructureWithListOfInteger(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldFindSingleNumber() {
        leetCodeUnitTestInfrastructure.test();
    }
}