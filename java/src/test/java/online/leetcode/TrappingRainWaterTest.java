package online.leetcode;

import org.apache.commons.lang3.ArrayUtils;
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
public class TrappingRainWaterTest {
    @Parameters
    public static Collection<Pair<Integer[], Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0,1,0,2,1,0,1,3,2,1,2,1}
                                        , 6)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0}
                                        , 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0,0,0}
                                        , 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0,1,1}
                                        , 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1,1,1}
                                        , 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1,1,0}
                                        , 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1}
                                        , 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1,1}
                                        , 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1,0,1}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2147483647,0,2147483647}
                                        , 2147483647)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1,4,1,0,4}
                                        , 7)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1,4,1,0,3}
                                        , 5)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0,1,0,2,0,0,1,1,0,2,3,0,0}
                                        , 9)
                });
    }

    private int[] fInput;
    private int fExpected;

    public TrappingRainWaterTest(Pair<Integer[], Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = ArrayUtils.toPrimitive(inputExpectedPair.getLeft());
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldCountWaterTrapped() {
        assertEquals(fExpected, new TrappingRainWater().trap(fInput));
    }
}