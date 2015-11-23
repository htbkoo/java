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
 * Created by Hey on 9/10/15
 */
@RunWith(Parameterized.class)
public class ClimbingStairsTest {
    @Parameters
    public static Collection<Pair<Integer, Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (0, 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2, 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                (3, 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (4, 5)
                }, new Pair[]{
                        new ImmutablePair<>
                                (5, 8)
                }, new Pair[]{
                        new ImmutablePair<>
                                (6, 13)
                }, new Pair[]{
                        new ImmutablePair<>
                                (43762, 528854761)
                });
    }

    private int fInput;
    private int fExpected;

    public ClimbingStairsTest(Pair<Integer, Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldGetNoOfDistinctWaysForClimbStairs() {
        assertEquals(fExpected, new ClimbingStairs().climbStairs(fInput));
    }
}