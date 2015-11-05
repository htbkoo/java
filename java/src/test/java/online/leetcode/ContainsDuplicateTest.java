package online.leetcode;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static java.lang.Boolean.TRUE;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 19/10/15
 */
@RunWith(Parameterized.class)
public class ContainsDuplicateTest {
    @Parameterized.Parameters
    public static Collection<Pair<Integer[], Boolean>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], Boolean>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, -2, 3}
                                        , TRUE)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, 1, 3}
                                        , Boolean.FALSE)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{}
                                        , Boolean.FALSE)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0}
                                        , Boolean.FALSE)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 17, 23, 3, 3, 1, 23}
                                        , TRUE)
                });
    }

    private int[] fInput;
    private boolean fExpected;

    public ContainsDuplicateTest(Pair<Integer[], Boolean> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = ArrayUtils.toPrimitive(inputExpectedPair.getLeft());
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldCheckIfContainsDuplicate() {
        assertEquals(fExpected, new ContainsDuplicate().containsDuplicate(fInput));
    }
}