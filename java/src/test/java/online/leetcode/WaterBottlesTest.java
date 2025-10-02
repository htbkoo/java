package online.leetcode;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class WaterBottlesTest {
    @Parameterized.Parameters
    public static Collection<Pair<Pair<Integer, Integer>, Integer>[]> data() {
        //noinspection unchecked
        return Arrays.asList(
                new Pair[]{
                        new ImmutablePair<>(
                                new ImmutablePair<>(9, 3),
                                13
                        )},
                new Pair[]{
                        new ImmutablePair<>(
                                new ImmutablePair<>(15, 4),
                                19
                        )});
    }

    private Pair<Integer, Integer> fInput;
    private int fExpected;

    public WaterBottlesTest(Pair<Pair<Integer, Integer>, Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldGetNumberOfDrink() {
        assertThat(new WaterBottles().numWaterBottles(fInput.getLeft(), fInput.getRight()), is(fExpected));
    }


}
