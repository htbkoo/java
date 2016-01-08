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
 * Created by Hey on 25/10/15
 */
@RunWith(Parameterized.class)
public class PowerOfThreeTest {

    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameters
    public static Collection<Pair<Integer, Boolean>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, Boolean>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (19, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (3, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (27, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (81, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (4, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (5, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (6, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (7, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (8, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (9, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (10, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (11, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (12, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (13, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (14, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1000, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (38, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (43762, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2147483647, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1162261467, true)
                });
    }

    public PowerOfThreeTest(Pair<Integer, Boolean> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createLeetCodeUnitTestPairInfrastructureWithInput(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldCheckIsPowerOfThree() {
        leetCodeUnitTestInfrastructure.test();
    }
}