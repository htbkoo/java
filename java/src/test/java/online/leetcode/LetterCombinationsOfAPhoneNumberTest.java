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
import java.util.Collections;

/**
 * Created by Hey on 12/1/16
 */
@RunWith(Parameterized.class)
public class LetterCombinationsOfAPhoneNumberTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameters
    public static Collection<Pair<String, Collection<? extends String>>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<String, Collection<? extends String>>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                ("2", Arrays.asList("a", "b", "c"))
                }, new Pair[]{
                        new ImmutablePair<>
                                ("", Collections.EMPTY_LIST)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("111", Collections.EMPTY_LIST)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("23", Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
                });
    }

    public LetterCombinationsOfAPhoneNumberTest(Pair<String, Collection<? extends String>> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createWithAssertionIgnoringOrder(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldCheckIsPalindrome() {
        leetCodeUnitTestInfrastructure.test();
    }
}