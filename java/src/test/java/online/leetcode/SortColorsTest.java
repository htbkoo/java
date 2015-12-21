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
 * Created by Hey on 21/12/15
 */
@RunWith(Parameterized.class)
public class SortColorsTest {
    @Parameterized.Parameters
    public static Collection<Pair<Integer[], Integer[]>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], Integer[]>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0}, new Integer[]{0})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1}, new Integer[]{1})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2}, new Integer[]{2})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 0}, new Integer[]{0, 0})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 1}, new Integer[]{0, 1})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 2}, new Integer[]{2, 2})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{}, new Integer[]{})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 2, 1, 2}, new Integer[]{1, 1, 2, 2})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 1, 2, 1}, new Integer[]{1, 1, 2, 2})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 1, 1, 1, 0}, new Integer[]{0, 1, 1, 1, 1})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 1, 1, 1, 1}, new Integer[]{0, 1, 1, 1, 1})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 1, 1, 1, 2}, new Integer[]{1, 1, 1, 1, 2})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 1, 1, 1, 1}, new Integer[]{1, 1, 1, 1, 2})
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 1, 0, 0, 1, 0, 0, 1, 0, 2, 2, 1, 1, 0}, new Integer[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2})
                });
    }

    private int[] fInput;
    private int[] fExpected;

    public SortColorsTest(Pair<Integer[], Integer[]> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = ArrayUtils.toPrimitive(inputExpectedPair.getLeft());
        fExpected = ArrayUtils.toPrimitive(inputExpectedPair.getRight());
    }

    @Test
    public void shouldSortColors() {
        new SortColors().sortColors(fInput);
        assertArrayEquals(fExpected, fInput);
    }
}