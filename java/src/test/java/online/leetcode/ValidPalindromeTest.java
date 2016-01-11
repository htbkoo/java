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
 * Created by Hey on 12/1/16
 */
@RunWith(Parameterized.class)
public class ValidPalindromeTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameters
    public static Collection<Pair<String, Boolean>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<String, Boolean>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                ("1a", false)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("", true)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("aab", false)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("aba", true)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("A man, a plan, a canal: Panama", true)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("a a", true)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("race a car", false)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("a ", true)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("a b", false)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("ab ", false)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("a11", false)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("a1bcedb1a", false)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("a1a", true)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("aaabbaaa", true)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("aaabcbaaa", true)
                });
    }

    public ValidPalindromeTest(Pair<String, Boolean> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createLeetCodeUnitTestPairInfrastructureWithInput(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldCheckIsPalindrome() {
        leetCodeUnitTestInfrastructure.test();
    }
}