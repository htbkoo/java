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
 * Created by Hey on 2 Jul 2016
 */
@RunWith(Parameterized.class)
public class ValidPerfectSquareTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameterized.Parameters
    public static Collection<Pair<Integer, Boolean>[]> data() {
        //noinspection unchecked
        return Arrays.asList(
                new Pair[]{
                        new ImmutablePair<>
                                (0
                                        , false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (14
                                        , false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2
                                        , false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2_147_483_647
                                        , false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1_073_676_289
                                        , true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (16
                                        , true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1
                                        , true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (4
                                        , true)
                }
        );
    }

    public ValidPerfectSquareTest(Pair<Integer, Boolean> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.createLeetCodeUnitTestPairInfrastructureWithInput(
                LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                inputExpectedPair
        );
    }

    @Test
    public void shouldFindSingleNumber() {
        leetCodeUnitTestInfrastructure.test();
    }


}