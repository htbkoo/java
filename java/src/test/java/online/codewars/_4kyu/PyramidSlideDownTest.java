package online.codewars._4kyu;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static online.codewars._4kyu.PyramidSlideDown.LongestSlideDown;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Hey on 3 Jul 2016
 */
@RunWith(Parameterized.class)
public class PyramidSlideDownTest {

    @Parameterized.Parameters(name = "[{index}]")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{
                        "description test case",
                        new int[][]{{3},
                                {7, 4},
                                {2, 4, 6},
                                {8, 5, 9, 3},
                        },
                        23,
                },
                new Object[]{
                        "test case",
                        new int[][]{{75},
                                {95, 64},
                                {17, 47, 82},
                                {18, 35, 87, 10},
                                {20, 4, 82, 47, 65},
                                {19, 1, 23, 75, 3, 34},
                                {88, 2, 77, 73, 7, 63, 67},
                                {99, 65, 4, 28, 6, 16, 70, 92},
                                {41, 41, 26, 56, 83, 40, 80, 70, 33},
                                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
                                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
                                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23},
                        },
                        1074,
                }
        );
    }

    private final int[][] fParams;
    private final int fExpected;

    public PyramidSlideDownTest(@SuppressWarnings("UnusedParameters") String name, int[][] fParams, int fExpected) {
        this.fParams = fParams;
        this.fExpected = fExpected;
    }

    @Test
    public void shouldGetMaxFromPyramid() throws Exception {
        assertThat(LongestSlideDown.longestSlideDown(fParams), is(fExpected));
    }

    @Ignore
    @Test
    public void test() {
        int[][] test = new int[][]{{75},
                {95, 64},
                {17, 47, 82},
                {18, 35, 87, 10},
                {20, 4, 82, 47, 65},
                {19, 1, 23, 75, 3, 34},
                {88, 2, 77, 73, 7, 63, 67},
                {99, 65, 4, 28, 6, 16, 70, 92},
                {41, 41, 26, 56, 83, 40, 80, 70, 33},
                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23},
        };
        assertEquals(1074, LongestSlideDown.longestSlideDown(test));
    }
}