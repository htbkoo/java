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
 * Created by Hey on 26 Jun 2016
 */
@RunWith(Parameterized.class)
public class IntegerBreakTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameterized.Parameters (name = "[{index}] - {0} - IntegerBreak.integerBreak")
    public static Collection<Pair<Integer, Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (2
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (3
                                        , 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                (4
                                        , 4)
                }, new Pair[]{
                        new ImmutablePair<>
                                (5
                                        , 6)
                }, new Pair[]{
                        new ImmutablePair<>
                                (6
                                        , 9)
                }, new Pair[]{
                        new ImmutablePair<>
                                (7
                                        , 12)
                }, new Pair[]{
                        new ImmutablePair<>
                                (8
                                        , 18)
                }, new Pair[]{
                        new ImmutablePair<>
                                (9
                                        , 27)
                }, new Pair[]{
                        new ImmutablePair<>
                                (10
                                        , 36)
                }, new Pair[]{
                        new ImmutablePair<>
                                (11
                                        , 54)
                }, new Pair[]{
                        new ImmutablePair<>
                                (12
                                        , 81)
                }, new Pair[]{
                        new ImmutablePair<>
                                (13
                                        , 108)
                }, new Pair[]{
                        new ImmutablePair<>
                                (40
                                        , 2125764)
                }, new Pair[]{
                        new ImmutablePair<>
                                (57
                                        , 1162261467)
                }, new Pair[]{
                        new ImmutablePair<>
                                (58
                                        , 1549681956)
                }, new Pair[]{
                        new ImmutablePair<>
                                (59
                                        , 2066242608)
                }, new Pair[]{
                        new ImmutablePair<>
                                (60
                                        , 2066242608)
                });
    }

    public IntegerBreakTest(Pair<Integer, Integer> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createLeetCodeUnitTestPairInfrastructureWithInput(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldGetIntegerBreak() {
        leetCodeUnitTestInfrastructure.test();
    }

}