package online.leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class AvoidFloodInTheCityTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new int[]{1, 2, 3, 4},
                        new int[]{-1, -1, -1, -1},
                },
                {
                        new int[]{1, 2, 0, 0, 2, 1},
                        new int[]{-1, -1, 2, 1, -1, -1},
                },
                {
                        new int[]{1, 2, 0, 1, 2},
                        new int[]{},
                },
                {
                        new int[]{1, 1, 0},
                        new int[]{},
                },
                {
                        new int[]{1, 0, 1},
                        new int[]{-1, 1, -1},
                },
                {
                        new int[]{1, 0, 2, 0, 2, 1},
                        new int[]{-1, 1, -1, 2, -1, -1},
                },
                {
                        new int[]{0, 1, 1},
                        new int[]{},
                },
                {
                        new int[]{1, 0, 2, 3, 0, 1, 2},
                        new int[]{-1, 1, -1, -1, 2, -1, -1},
                },
        });
    }

    private final int[] fInput;
    private final int[] fExpected;

    public AvoidFloodInTheCityTest(int[] input, int[] expected) {
        fInput = input;
        fExpected = expected;
    }

    @Test
    public void shouldFindCellsFlowingToBothOceans() {
        var actual = new AvoidFloodInTheCity().avoidFlood(fInput);
        assertThat(actual, is(fExpected));
    }
}
