package online.leetcode;

import online.leetcode.infrastructure.LeetCodeUnitTestInfrastructure;
import online.leetcode.infrastructure.LeetCodeUnitTestInfrastructureForOneInput;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Hey on 16/10/15
 */
@RunWith(Parameterized.class)
public class JumpGameTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameterized.Parameters
    public static Collection<Pair<Integer[], Boolean>[]> data() throws IOException {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], Boolean>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0}, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 3, 1, 1, 4}, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 3, 1, 0, 4}, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 3, 0, 0, 4}, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{3, 2, 1, 0, 4}, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 1}, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 2, 3}, false)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 3, 1}, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{3, 2, 1, 1, 0}, true)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{3, 2, 1, 1, 0}, true)
                });
    }

    public JumpGameTest(Pair<Integer[], Boolean> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createLeetCodeUnitTestPairInfrastructureWithListOfInteger(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldCheckIfCanJump() {
        leetCodeUnitTestInfrastructure.test();
    }
}
