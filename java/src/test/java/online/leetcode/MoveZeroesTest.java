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

import static org.junit.Assert.assertTrue;

/**
 * Created by Hey on 9/10/15
 */
@RunWith(Parameterized.class)
public class MoveZeroesTest {
    @Parameters
    public static Collection<Pair<Integer[], Integer[]>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], Integer[]>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, -2, 3}
                                        , new Integer[]{-2, -2, 3})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, 0, 1, 0, 3}
                                        , new Integer[]{-2, 1, 3, 0, 0})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 1, 0, 3, 12}
                                        , new Integer[]{1, 3, 12, 0, 0})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0}
                                        , new Integer[]{0})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 0}
                                        , new Integer[]{0, 0})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 1}
                                        , new Integer[]{1, 0})
                });
    }

    private int[] fInput;
    private int[] fExpected;

    public MoveZeroesTest(Pair<Integer[], Integer[]> inputExpectedPair) {
        fInput = ArrayUtils.toPrimitive(inputExpectedPair.getLeft());
        fExpected = ArrayUtils.toPrimitive(inputExpectedPair.getRight());
    }

    @Test
    public void shouldMoveZeroes() {
        new MoveZeroes().moveZeroes(fInput);
        assertTrue(Arrays.equals(fExpected, fInput));
    }
}