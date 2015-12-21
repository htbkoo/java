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

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Created by Hey on 19/10/15
 */
@RunWith(Parameterized.class)
public class PowerOfTwoTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameterized.Parameters
    public static Collection<Pair<Integer, Boolean>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, Boolean>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (1048576
                                        , TRUE)
                }, new Pair[]{
                        new ImmutablePair<>
                                (99
                                        , FALSE)
                }, new Pair[]{
                        new ImmutablePair<>
                                (3
                                        , FALSE)
                }, new Pair[]{
                        new ImmutablePair<>
                                (-1
                                        , FALSE)
                }, new Pair[]{
                        new ImmutablePair<>
                                (0
                                        , FALSE)
                }, new Pair[]{
                        new ImmutablePair<>
                                (65536
                                        , TRUE)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1024
                                        , TRUE)
                }, new Pair[]{
                        new ImmutablePair<>
                                (4
                                        , TRUE)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1
                                        , TRUE)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2
                                        , TRUE)
                });
    }

    public PowerOfTwoTest(Pair<Integer, Boolean> inputExpectedPair) throws ClassNotFoundException {
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