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
 * Created by Hey on 28/4/16
 */
@RunWith(Parameterized.class)
public class ReverseVowelsOfAStringTest {
    final LeetCodeUnitTestInfrastructure leetCodeUnitTestInfrastructure;

    @Parameterized.Parameters
    public static Collection<Pair<String, String>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<String, String>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (""
                                        , "")
                }, new Pair[]{
                        new ImmutablePair<>
                                ("{"
                                        , "{")
                }, new Pair[]{
                        new ImmutablePair<>
                                ("a"
                                        , "a")
                }, new Pair[]{
                        new ImmutablePair<>
                                ("hello"
                                        , "holle")
                }, new Pair[]{
                        new ImmutablePair<>
                                ("leetcode"
                                        , "leotcede")
                }, new Pair[]{
                        new ImmutablePair<>
                                ("Ahello Custom Testcas Run Code Status: Finished "
                                        , "ehilli Custam Testcos Run Cade Stotus: FoneshAd ")
                });
    }

    public ReverseVowelsOfAStringTest(Pair<String, String> inputExpectedPair) throws ClassNotFoundException {
//        This method may be nasty and it should be improved
        leetCodeUnitTestInfrastructure = LeetCodeUnitTestInfrastructureForOneInput.
                createLeetCodeUnitTestPairInfrastructureWithInput(
                        LeetCodeUnitTestInfrastructureForOneInput.getClassUnderTest(this.getClass()),
                        inputExpectedPair
                );
    }

    @Test
    public void shouldReverseVowels() {
        leetCodeUnitTestInfrastructure.test();
    }

}