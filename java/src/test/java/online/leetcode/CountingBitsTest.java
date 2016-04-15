package online.leetcode;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Hey on 15/4/16
 */
@RunWith(Parameterized.class)
public class CountingBitsTest {
    @Parameterized.Parameters
    public static Collection<Pair<Integer, Integer[]>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, Integer[]>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (5
                                        , new Integer[]{0, 1, 1, 2, 1, 2})
                }, new Pair[]{
                        new ImmutablePair<>
                                (4
                                        , new Integer[]{0, 1, 1, 2, 1})
                }, new Pair[]{
                        new ImmutablePair<>
                                (3
                                        , new Integer[]{0, 1, 1, 2})
                }, new Pair[]{
                        new ImmutablePair<>
                                (2
                                        , new Integer[]{0, 1, 1})
                }, new Pair[]{
                        new ImmutablePair<>
                                (0
                                        , new Integer[]{0})
                }, new Pair[]{
                        new ImmutablePair<>
                                (16
                                        , new Integer[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1})
                }, new Pair[]{
                        new ImmutablePair<>
                                (100
                                        , new Integer[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3})
                });
    }

    private int fInput;
    private int[] fExpected;

    public CountingBitsTest(Pair<Integer, Integer[]> inputExpectedPair) throws ClassNotFoundException {
        fInput = inputExpectedPair.getLeft();
        fExpected = ArrayUtils.toPrimitive(inputExpectedPair.getRight());
    }

    @Test
    public void shouldCountBits() {
        assertArrayEquals(fExpected, new CountingBits().countBits(fInput));
    }

}