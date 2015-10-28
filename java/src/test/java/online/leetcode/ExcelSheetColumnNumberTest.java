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
public class ExcelSheetColumnNumberTest {
    @Parameters
    public static Collection<Pair<String, Integer>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<String, Integer>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                ("", 0)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("A", 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("B", 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("Z", 26)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("AA", 27)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("AB", 28)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("AZ", 52)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("Z", 26)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("BA", 53)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("ZZ", 702)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("AAA", 703)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("ABC", 731)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("ZZZZZ", 12_356_630)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("FXSHRXW", 2147483647)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("A", 1)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("B", 2)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("C", 3)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("D", 4)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("ALL", 1000)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("AA", 27)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("AB", 28)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("AZ", 52)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("BA", 53)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("BZ", 78)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("CA", 79)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("ZZ", 702)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("AAA", 703)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("AAZ", 728)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("ABA", 729)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("ABB", 730)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("ABC", 731)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("AL", 38)
                }, new Pair[]{
                        new ImmutablePair<>
                                ("BLSD", 43762)
                });
    }

    private String fInput;
    private int fExpected;

    public ExcelSheetColumnNumberTest(Pair<String, Integer> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldAddDigits() {
        assertEquals(fExpected, new ExcelSheetColumnNumber().titleToNumber(fInput));
    }
}