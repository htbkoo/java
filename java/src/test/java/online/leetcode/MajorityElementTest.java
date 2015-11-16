package online.leetcode;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Hey on 19/10/15
 */
@RunWith(Parameterized.class)
public class MajorityElementTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameterized.Parameters
    public static Collection<Pair<Integer[], Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer[], Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{-2, -2, 3}
                                        , -2)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 1, 3}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1, 17, 23, 23, 23, 1, 23}
                                        , 23)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{1,2,3,4,5,1,1,1,1,1}
                                        , 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                (new Integer[]{2,1,3,1,4,1,5,1,1}
                                        , 1)
                });
    }

    public MajorityElementTest(Pair<Integer[], Integer> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                <Integer[], Integer>createLeetCodeUnitTestPairInfrastructureWithListOfInteger(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldFindMajorityElement() {
        leetCodeUnitTestInfrastructure.test();
    }

}