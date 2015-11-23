package online.leetcode;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 25/10/15
 */
@RunWith(Parameterized.class)
public class RomanToIntegerTest {
    @Parameters
    public static Collection<Pair<String, Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<String, Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                ("I", 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("II", 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("III", 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("IV", 4)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("V", 5)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("VI", 6)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("VIII", 8)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("IX", 9)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("X", 10)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("XIV", 14)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("XXIV", 24)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("XXIX", 29)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("L", 50)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("LIX", 59)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("LXXXIX", 89)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("XCIX", 99)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("C", 100)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("CIX", 109)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("CXCIX", 199)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("CDXCIX", 499)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("CM", 900)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("DCCCXCVIII", 898)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("MCMXCVIII", 1998)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("MMM", 3000)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("MMMCMXCIX", 3999)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("MCMLIV", 1954)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("MCMXC", 1990)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("MMXIV", 2014)
                });
    }

    private String fInput;
    private int fExpected;

    public RomanToIntegerTest(Pair<String, Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldConvertRomanToInt() {
        assertEquals(fExpected, new RomanToInteger().romanToInt(fInput));
    }
}