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

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Hey on 9/10/15
 */
@RunWith(Parameterized.class)
public class PlusOneTest {
    @Parameters
    public static Collection<Pair<Integer[], Integer[]>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], Integer[]>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 2, 3}
                                        , new Integer[]{2, 2, 4})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 2, 1, 3, 3}
                                        , new Integer[]{2, 2, 1, 3, 4})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0}
                                        , new Integer[]{1})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{9}
                                        , new Integer[]{1, 0})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2,1,4,7,4,8,3,6,4,9}
                                        , new Integer[]{2,1,4,7,4,8,3,6,5,0})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{9, 9}
                                        , new Integer[]{1, 0, 0})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 9}
                                        , new Integer[]{2, 0})
                });
    }

    private int[] fInput;
    private int[] fExpected;

    public PlusOneTest(Pair<Integer[], Integer[]> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = ArrayUtils.toPrimitive(inputExpectedPair.getLeft());
        fExpected = ArrayUtils.toPrimitive(inputExpectedPair.getRight());
    }

    @Test
    public void shouldFindPlusOne() {
        assertArrayEquals(fExpected, new PlusOne().plusOne(fInput));
    }
}