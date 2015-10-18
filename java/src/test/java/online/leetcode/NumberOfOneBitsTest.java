package online.leetcode;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 18/10/15
 */
@RunWith(Parameterized.class)
public class NumberOfOneBitsTest {
    @Parameterized.Parameters
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
                                (11, 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (9, 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                (10, 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                (11, 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (3, 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                (4, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (-1, 32)
                }, new Pair[]{
                        new ImmutablePair<>
                                (-2, 31)
                }, new Pair[]{
                        new ImmutablePair<>
                                (-3, 31)
                }, new Pair[]{
                        new ImmutablePair<>
                                (38, 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (43762, 9)
                });
    }

    private int fInput;
    private int fExpected;

    public NumberOfOneBitsTest(Pair<Integer, Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldAddDigits() {
        assertEquals(fExpected, new NumberOfOneBits().hammingWeight(fInput));
    }

}