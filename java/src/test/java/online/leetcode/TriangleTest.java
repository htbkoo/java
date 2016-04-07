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
 * Created by Hey on 7/4/16
 */
@RunWith(Parameterized.class)
public class TriangleTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameterized.Parameters
    public static Collection<Pair<List<List<Integer>>, Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<List<List<Integer>>, Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (Arrays.asList(
                                        Collections.singletonList(1),
                                        Arrays.asList(9,1),
                                        Arrays.asList(9,9,1),
                                        Arrays.asList(-100,9,9,1)
                                )
                                        , -81)
                }, new Pair[]{
                        new ImmutablePair<>
                                (Collections.singletonList(
                                        Collections.singletonList(-10)
                                )
                                        , -10)
                }, new Pair[]{
                        new ImmutablePair<>
                                (Arrays.asList(
                                        Collections.singletonList(2),
                                        Arrays.asList(3,4),
                                        Arrays.asList(6,5,7),
                                        Arrays.asList(4,1,8,3)
                                )
                                        , 11)
                }, new Pair[]{
                        new ImmutablePair<>
                                (Arrays.asList(
                                        Collections.singletonList(2),
                                        Arrays.asList(3,4),
                                        Arrays.asList(6,5,7),
                                        Arrays.asList(4,1,8,3)
                                )
                                        , 11)
                });
    }

    public TriangleTest(Pair<List<List<Integer>>, Integer> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createLeetCodeUnitTestPairInfrastructureWithInput(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldGetMinimumTotal() {
        leetCodeUnitTestInfrastructure.test();
    }

}