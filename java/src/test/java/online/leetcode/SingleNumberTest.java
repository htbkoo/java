package online.leetcode;

import online.leetcode.infrastructure.LeetCodeUnitTestInfrastructure;
import online.leetcode.infrastructure.LeetCodeUnitTestInfrastructureForOneInput;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Hey on 9/10/15
 */
@RunWith(Parameterized.class)
public class SingleNumberTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameters
    public static Collection<Pair<Integer[], Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, -2, 3}
                                        , 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, -2, 1, 3, 3}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 17, 23, 3, 3, 1, 23}
                                        , 17)
                });
    }

    public SingleNumberTest(Pair<Integer[], Integer> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createLeetCodeUnitTestPairInfrastructureWithListOfInteger(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldFindSingleNumber() {
        leetCodeUnitTestInfrastructure.test();
    }
}