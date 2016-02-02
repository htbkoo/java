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
import java.util.List;

/**
 * Created by Hey on 2/2/16
 */
@RunWith(Parameterized.class)
public class SummaryRangesTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameterized.Parameters
    public static Collection<Pair<Integer[], List<String>>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], List<String>>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0, 1, 2, 4, 5, 7}
                                        , Arrays.asList("0->2", "4->5", "7"))
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, 1, 3}
                                        , Arrays.asList("-2", "1", "3"))
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{}
                                        , Collections.emptyList())
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{0}
                                        , Collections.singletonList("0"))
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 2, 3, 4, 5, 9, 10, 11, 12}
                                        , Arrays.asList("1->5", "9->12"))
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2147483648, -2147483647, 2147483647}
                                        , Arrays.asList("-2147483648->-2147483647", "2147483647"))
                });
    }

    public SummaryRangesTest(Pair<Integer[], List<String>> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createLeetCodeUnitTestPairInfrastructureWithListOfInteger(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldCheckIfContainsDuplicate() {
        leetCodeUnitTestInfrastructure.test();
    }

}