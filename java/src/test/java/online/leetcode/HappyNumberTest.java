package online.leetcode;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.BeforeClass;
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
public class HappyNumberTest {
    @Parameters
    public static Collection<Pair<Integer, Boolean>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, Boolean>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (19, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (2, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (3, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (4, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (5, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (6, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (7, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (8, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (9, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (10, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (11, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (12, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (13, true)
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

    public HappyNumberTest(Pair<Integer, Boolean> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

//    @Test
    @BeforeClass
    public static void shouldBuildCorrectSquareDigitMap() {
        for (int i = 0; i < 10; ++i) {
            assertEquals(i * i, HappyNumber.digitSquare.get(i).intValue());
        }
    }

    @Test
    public void shouldTestIsHappy() {
        assertEquals(fExpected, new HappyNumber().isHappy(fInput));
    }
}