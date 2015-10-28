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
public class ExcelSheetColumnTitleTest {
    @Parameters
    public static Collection<Pair<Integer, String>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, String>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (2147483647, "FXSHRXW")
                }, new Pair[]{
                        new ImmutablePair<>
                                (1, "A")
                }, new Pair[]{
                        new ImmutablePair<>
                                (2, "B")
                }, new Pair[]{
                        new ImmutablePair<>
                                (3, "C")
                }, new Pair[]{
                        new ImmutablePair<>
                                (4, "D")
                }, new Pair[]{
                        new ImmutablePair<>
                                (1000, "ALL")
                }, new Pair[]{
                        new ImmutablePair<>
                                (27, "AA")
                }, new Pair[]{
                        new ImmutablePair<>
                                (28, "AB")
                }, new Pair[]{
                        new ImmutablePair<>
                                (52, "AZ")
                }, new Pair[]{
                        new ImmutablePair<>
                                (53, "BA")
                }, new Pair[]{
                        new ImmutablePair<>
                                (78, "BZ")
                }, new Pair[]{
                        new ImmutablePair<>
                                (79, "CA")
                }, new Pair[]{
                        new ImmutablePair<>
                                (702, "ZZ")
                }, new Pair[]{
                        new ImmutablePair<>
                                (703, "AAA")
                }, new Pair[]{
                        new ImmutablePair<>
                                (728, "AAZ")
                }, new Pair[]{
                        new ImmutablePair<>
                                (729, "ABA")
                }, new Pair[]{
                        new ImmutablePair<>
                                (730, "ABB")
                }, new Pair[]{
                        new ImmutablePair<>
                                (731, "ABC")
                }, new Pair[]{
                        new ImmutablePair<>
                                (38, "AL")
                }, new Pair[]{
                        new ImmutablePair<>
                                (43762, "BLSD")
                });
    }

    private int fInput;
    private String fExpected;

    public ExcelSheetColumnTitleTest(Pair<Integer, String> inputExpectedPair) {
//        This method may be nasty and it should be improved
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldAddDigits() {
        assertEquals(fExpected, new ExcelSheetColumnTitle().convertToTitle(fInput));
    }
}