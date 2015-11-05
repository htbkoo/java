package online.leetcode;

import com.google.common.base.Splitter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 16/10/15
 */
@RunWith(Parameterized.class)
public class JumpGameIITest {
    @Parameterized.Parameters
    public static Collection<Pair<Integer[], Integer>[]> data() throws IOException {
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
                                (new Integer[]{2, 3, 1, 1, 4}, 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 1}, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 3, 1}, 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (getTwentyFiveThousandsTestCase(), 2)
                });
    }

    private static Integer[] getTwentyFiveThousandsTestCase() throws IOException {
        return ArrayUtils.toObject(
                StreamSupport.stream(
                        Splitter.on(',').split(
                                FileUtils.readFileToString(
                                        FileUtils.toFile(
                                                JumpGameIITest.class.getClassLoader().getResource("JumpGameIITest_testCase")
                                        )
                                )
                        ).spliterator(), false)
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .toArray()
        );
    }

    private int[] fInput;
    private int fExpected;

    public JumpGameIITest(Pair<Integer[], Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = ArrayUtils.toPrimitive(inputExpectedPair.getLeft());
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldGetMaxProfit() {
        assertEquals(fExpected, new JumpGameII().jump(fInput));
    }
}
