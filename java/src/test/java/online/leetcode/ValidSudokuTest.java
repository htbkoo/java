package online.leetcode;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Hey on 5/2/16
 */
@RunWith(Parameterized.class)
public class ValidSudokuTest {
    @Parameterized.Parameters
    public static Collection<Pair<String[], Boolean>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<String[], Boolean>[]>asList(
                new Pair[]{
                        new ImmutablePair<>(
                                new String[]{"..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.."},
                                TRUE
                        )},
                new Pair[]{
                        new ImmutablePair<>(
                                new String[]{".87654321","2........","3........","4........","5........","6........","7........","8........","9........"},
                                TRUE
                        )},
                new Pair[]{
                        new ImmutablePair<>(
                                new String[]{".........",".........",".........",".........",".........",".........",".........",".........","........."},
                                TRUE
                        )},
                new Pair[]{
                        new ImmutablePair<>(
                                new String[]{"887654321","2........","3........","4........","5........","6........","7........","8........","9........"},
                                FALSE
                        )
                },
                new Pair[]{
                        new ImmutablePair<>(
                                new String[]{"...9.....",".........","..3.....1",".........","1.....3..","....2.6..",".9.....7.",".........","8..8....."},
                                FALSE
                        )
                });
    }

    private char[][] fInput;
    private boolean fExpected;

    public ValidSudokuTest(Pair<String[], Boolean> inputExpectedPair) {
//        This method may be nasty and it should be improved
        final String[] inputStringArrays = inputExpectedPair.getLeft();
        final int ilength = inputStringArrays.length;
        fInput = new char[ilength][];
        convertStringArrayToBoard(inputStringArrays, fInput);
        fExpected = inputExpectedPair.getRight();
    }

    private void convertStringArrayToBoard(String[] sourceStringArrays, char[][] target) {
        final int slength = sourceStringArrays.length;
        for (int i = 0; i < slength; ++i) {
            target[i] = sourceStringArrays[i].toCharArray();
        }
    }

    @Test
    public void shouldCheckIsValidSudoku() {
        assertThat(new ValidSudoku().isValidSudoku(fInput),is(fExpected));
    }

}