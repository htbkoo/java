package online.leetcode;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static java.lang.Boolean.*;
import static java.lang.Boolean.TRUE;

/**
 * Created by Hey on 19/10/15
 */
@RunWith(Parameterized.class)
public class ValidParenthesesTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameterized.Parameters
    public static Collection<Pair<String, Boolean>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<String, Boolean>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (""
                                        , TRUE)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("{"
                                        , FALSE)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("{(})"
                                        , FALSE)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("}{"
                                        , FALSE)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("}"
                                        , FALSE)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("{()}"
                                        , TRUE)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("{}()"
                                        , TRUE)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("[]"
                                        , TRUE)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("{}"
                                        , TRUE)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("()[]{}"
                                        , TRUE)
                });
    }

    public ValidParenthesesTest(Pair<String, Boolean> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createLeetCodeUnitTestPairInfrastructureWithInput(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldCheckIsValidParentheses() {
        leetCodeUnitTestInfrastructure.test();
    }

}