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
 * Created by Hey on 5/12/15
 */
@RunWith(Parameterized.class)
public class FactorialTrailingZeroesTest {
    @Parameters
    public static Collection<Pair<Integer, Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (0, 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1, 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (5, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (9, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (10, 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                (38, 8)
                }, new Pair[]{
                        new ImmutablePair<>
                                (99, 22)
                }, new Pair[]{
                        new ImmutablePair<>
                                (125, 31)
                }, new Pair[]{
                        new ImmutablePair<>
                                (123456, 30860)
                }, new Pair[]{
                        new ImmutablePair<>
                                (210000000, 52499997)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1000000003 , 249999998)
                });
    }

    private int fInput;
    private int fExpected;

    public FactorialTrailingZeroesTest(Pair<Integer, Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldGetNumberOfTrailingZeroes() {
        assertEquals(fExpected, new FactorialTrailingZeroes().trailingZeroes(fInput));
    }
}