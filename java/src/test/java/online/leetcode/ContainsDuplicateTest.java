package online.leetcode;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static java.lang.Boolean.TRUE;

/**
 * Created by Hey on 19/10/15
 */
@RunWith(Parameterized.class)
public class ContainsDuplicateTest{
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

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

    public ContainsDuplicateTest(Pair<Integer[], Boolean> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                <Integer[], Boolean>createLeetCodeUnitTestPairInfrastructureWithListOfInteger(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldCheckIfContainsDuplicate() {
        leetCodeUnitTestInfrastructure.test();
    }

}