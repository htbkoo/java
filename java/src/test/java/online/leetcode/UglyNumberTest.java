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
 * Created by Hey on 25/10/15
 */
@RunWith(Parameterized.class)
public class UglyNumberTest {
    @Parameters
    public static Collection<Pair<Integer, Boolean>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, Boolean>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (0, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (-2147483648, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (3, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (4, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (5, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (6, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (7, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (14, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1000, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (38, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (43762, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2147483647, false)
                });
    }

    private int fInput;
    private boolean fExpected;

    public UglyNumberTest(Pair<Integer, Boolean> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldTestIsUgly() {
        assertEquals(fExpected, new UglyNumber().isUgly(fInput));
    }
}