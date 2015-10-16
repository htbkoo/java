package online.leetcode;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 16/10/15
 */
@RunWith(Parameterized.class)
public class BestTimeToBuyAndSellStockTest {
    @Parameterized.Parameters
    public static Collection<Pair<Integer[], Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0}, 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{}, 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1,2,3,4}, 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{4,3,2,1}, 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1,3,5,2,3,6,7,8,1,0,1}, 7)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1,3,5,2,3,6,7,8,1,0,3,2,9}, 9)
                });
    }

    private int[] fInput;
    private int fExpected;

    public BestTimeToBuyAndSellStockTest(Pair<Integer[], Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = ArrayUtils.toPrimitive(inputExpectedPair.getLeft());
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldGetMaxProfit() {
        assertEquals(fExpected, new BestTimeToBuyAndSellStock().maxProfit(fInput));
    }
}