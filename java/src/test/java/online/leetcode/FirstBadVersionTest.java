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
 * Created by Hey on 29/1/16
 */
@RunWith(Parameterized.class)
public class FirstBadVersionTest {
    @Parameters
    public static Collection<Pair<Integer, Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (10, 5)
                }, new Pair[]{
                        new ImmutablePair<>
                                (9, 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (10, 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (11, 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (12, 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (15, 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (16, 4)
                }, new Pair[]{
                        new ImmutablePair<>
                                (19, 4)
                }, new Pair[]{
                        new ImmutablePair<>
                                (25, 5)
                }, new Pair[]{
                        new ImmutablePair<>
                                (100, 10)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2000000, 1414)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2147483647, 46340)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1000, 31)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (43762, 209)
                });
    }

    private int fInput;
    private int fExpected;

    public FirstBadVersionTest(Pair<Integer, Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldGetFirstBadVersion() {
        assertEquals(fExpected, new FirstBadVersion() {
            @Override
            protected boolean isBadVersion(int version) {
                return version >= fExpected;
            }
        }.firstBadVersion(fInput));
    }
}