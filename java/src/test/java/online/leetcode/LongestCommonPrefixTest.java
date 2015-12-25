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

/**
 * Created by Hey on 19/10/15
 */
@RunWith(Parameterized.class)
public class LongestCommonPrefixTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameterized.Parameters
    public static Collection<Pair<String[], String>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<String[], String>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (new String[]{}
                                        , "")
                }, new Pair[]{
                        new ImmutablePair<>
                                (new String[]{"a","b"}
                                        , "")
                }, new Pair[]{
                        new ImmutablePair<>
                                (new String[]{"aa","ab"}
                                        , "a")
                }, new Pair[]{
                        new ImmutablePair<>
                                (new String[]{"aa","aa"}
                                        , "aa")
                }, new Pair[]{
                        new ImmutablePair<>
                                (new String[]{"aa","aa","b"}
                                        , "")
                }, new Pair[]{
                        new ImmutablePair<>
                                (new String[]{"aa","aa","b"}
                                        , "")
                });
    }

    public LongestCommonPrefixTest(Pair<String[], String> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createLeetCodeUnitTestPairInfrastructureWithInput(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldFindLongestCommonPrefix() {
        leetCodeUnitTestInfrastructure.test();
    }

}