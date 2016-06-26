package online.leetcode;

import online.leetcode.RangeSumQuery2DImmutable.NumMatrix;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Hey on 26 Jun 2016.
 * <p>
 * ----
 * <p>
 * Simple non standard test;
 */
public class RangeSumQuery2DImmutableTest {

    @Test
    public void shouldPassLeetCodeSampleTest() throws Exception {
        NumMatrix numMatrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
                {0, 0, 0, 0, 0},
        });

        assertThat(numMatrix.sumRegion(2, 1, 4, 3), is(8));
        assertThat(numMatrix.sumRegion(1, 1, 2, 2), is(11));
        assertThat(numMatrix.sumRegion(1, 2, 2, 4), is(12));
    }

    @Test
    public void shouldPassEmptyTest() throws Exception {
        new NumMatrix(new int[][]{});
    }
}