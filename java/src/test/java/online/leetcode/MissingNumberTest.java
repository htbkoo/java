package online.leetcode;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 11/12/15
 */
@RunWith(Parameterized.class)
public class MissingNumberTest {
    @Parameterized.Parameters
    public static Collection<Pair<Integer[], Integer>[]> data() throws IOException {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0}, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1}, 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 1, 3}, 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 2, 3}, 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 2, 3}, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 1, 0}, 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 2, 4, 3, 5}, 0)
                });
    }

    private int[] fInput;
    private int fExpected;

    public MissingNumberTest(Pair<Integer[], Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = ArrayUtils.toPrimitive(inputExpectedPair.getLeft());
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldGetMissingNumber() {
        assertEquals(fExpected, new MissingNumber().missingNumber(fInput));
    }
}
