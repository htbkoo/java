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
public class ReverseIntegerTest {
    @Parameters
    public static Collection<Pair<Integer, Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (0, 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (9, 9)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (38, 83)
                }, new Pair[]{
                        new ImmutablePair<>
                                (123, 321)
                }, new Pair[]{
                        new ImmutablePair<>
                                (-123, -321)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1534236469, 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (10, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1000000003 , 0)
                });
    }

    private int fInput;
    private int fExpected;

    public ReverseIntegerTest(Pair<Integer, Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldReverseInteger() {
        assertEquals(fExpected, new ReverseInteger().reverse(fInput));
    }

    @Test
    public void shouldReverseIntegerWithoutStringBuilder() {
        assertEquals(fExpected, new ReverseInteger().reverseWithoutStringBuilder(fInput));
    }
}