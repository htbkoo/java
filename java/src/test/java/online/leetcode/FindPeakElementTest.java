package online.leetcode;

import online.leetcode.infrastructure.LeetCodeUnitTestInfrastructure;
import online.leetcode.infrastructure.LeetCodeUnitTestInfrastructureForOneInput;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Hey on 19/10/15
 */
@RunWith(Parameterized.class)
public class FindPeakElementTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameterized.Parameters
    public static Collection<Pair<Integer[], Collection<Integer>>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], Collection<Integer>>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, -2, 3}
                                        , Collections.singletonList(2))
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 1, 3}
                                        , Collections.singletonList(2))
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1}
                                        , Collections.singletonList(0))
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 1}
                                        , Collections.singletonList(0))
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 2}
                                        , Collections.singletonList(1))
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 17, 23, 22, 23, 1, 23}
                                        , Arrays.asList(2, 4, 6))
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 2, 3, 4, 5, 1, 1, 1, 1, 1}
                                        , Collections.singletonList(4))
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2, 1, 3, 1, 4, 1, 5, 1, 1}
                                        , Arrays.asList(0, 2, 4, 6))
                });
    }

    public FindPeakElementTest(Pair<Integer[], Collection<Integer>> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createWithExistenceAssertion(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldFindPeakElement() {
        leetCodeUnitTestInfrastructure.test();
    }

}