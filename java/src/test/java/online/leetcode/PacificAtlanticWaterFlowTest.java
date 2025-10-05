package online.leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class PacificAtlanticWaterFlowTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new int[][]{
                                {1, 2, 2, 3, 5},
                                {3, 2, 3, 4, 4},
                                {2, 4, 5, 3, 1},
                                {6, 7, 1, 4, 5},
                                {5, 1, 1, 2, 4}
                        },
                        Arrays.asList(
                                Arrays.asList(0, 4), Arrays.asList(1, 3), Arrays.asList(1, 4),
                                Arrays.asList(2, 2), Arrays.asList(3, 0), Arrays.asList(3, 1), Arrays.asList(4, 0)
                        )
                },
                {
                        new int[][]{{1}},
                        Arrays.asList(
                                Arrays.asList(0, 0)
                        )
                },
                {
                        new int[][]{
                                {1, 2, 3},
                                {8, 9, 4},
                                {7, 6, 5}
                        },
                        Arrays.asList(
                                Arrays.asList(0, 2), Arrays.asList(1, 0), Arrays.asList(1, 1),
                                Arrays.asList(1, 2), Arrays.asList(2, 0), Arrays.asList(2, 1), Arrays.asList(2, 2)
                        )
                },
                {
                        new int[][]{
                                {2, 1},
                                {1, 2}
                        },
                        Arrays.asList(
                                Arrays.asList(0, 0), Arrays.asList(0, 1), Arrays.asList(1, 0), Arrays.asList(1, 1)
                        )
                }
        });
    }

    private final int[][] fInput;
    private final List<List<Integer>> fExpected;

    public PacificAtlanticWaterFlowTest(int[][] input, List<List<Integer>> expected) {
        fInput = input;
        fExpected = expected;
    }

    @Test
    public void shouldFindCellsFlowingToBothOceans() {
        List<List<Integer>> actual = new PacificAtlanticWaterFlow().pacificAtlantic(fInput);
        assertThat(actual, is(fExpected));
    }
}
