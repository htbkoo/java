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
 * Created by Hey on 6/12/15
 */
@RunWith(Parameterized.class)
public class LengthOfLastWordTest {
    @Parameters
    public static Collection<Pair<String, Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<String, Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                ("", 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("I", 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("II", 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("III", 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("IV", 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("V", 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("VI", 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("VIII", 4)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("Hello World", 5)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("Subscribe to see which companies asked this question", 8)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("Subscribe to see which companies asked this question            ", 8)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("            ", 0)
                });
    }

    private String fInput;
    private int fExpected;

    public LengthOfLastWordTest(Pair<String, Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldGetLengthOfLastWord() {
        assertEquals(fExpected, new LengthOfLastWord().lengthOfLastWord(fInput));
    }
}