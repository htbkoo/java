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
public class DungeonGameTest {
    @Parameters
    public static Collection<Pair<Integer[][], Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer[][], Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[][]{
                                        {-2, -3, 3},
                                        {-5, -10, 1},
                                        {10, 30, -5}
                                }, 7)
                }, new Pair[]{new ImmutablePair<>
                        (new Integer[][]{
                                {0, -6, 13, -99},
                                {-3, 0, 0, -10},
                                {-99, -99, -10, 0}
                        }, 7)
                }, new Pair[]{new ImmutablePair<>
                        (new Integer[][]{
                                {0, -6, 13, -99, -99},
                                {-3, 0, 0, 0, 0},
                                {-99, 0, 0, 0, -10},
                                {-99, -99, 0, -10, 0}
                        }, 7)
                }, new Pair[]{new ImmutablePair<>
                        (new Integer[][]{
                                {0, -6, 13, -99},
                                {-3, 0, 0, 0},
                                {-99, -99, 0, 0}
                        }, 4)
                }, new Pair[]{new ImmutablePair<>
                        (new Integer[][]{
                                {0}
                        }, 1)
                }, new Pair[]{new ImmutablePair<>
                        (new Integer[][]{
                                {100}
                        }, 1)
                });
    }

    private int[][] fInput;
    private int fExpected;

    public DungeonGameTest(Pair<Integer[][], Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        final Integer[][] input = inputExpectedPair.getLeft();
        fInput = new int[input.length][];
        for (int i = 0; i < input.length; ++i) {
            fInput[i] = ArrayUtils.toPrimitive(input[i]);
        }
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldCalculateMinimumHP() {
        assertEquals(fExpected, new DungeonGame().calculateMinimumHP(fInput));
    }
}