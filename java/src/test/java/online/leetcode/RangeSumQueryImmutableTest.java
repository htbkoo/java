package online.leetcode;

import online.leetcode.RangeSumQueryImmutable.NumArray;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Hey on 5 Apr 2016.
 *
 * ----
 *
 * Simple non standard test;
 */
public class RangeSumQueryImmutableTest {

    @Test
    public void shouldPassLeetCodeSampleTest() throws Exception {
        NumArray numArray = new RangeSumQueryImmutable().new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assertThat(numArray.sumRange(0,0), is(-2));
        assertThat(numArray.sumRange(1,1), is(0));
        assertThat(numArray.sumRange(5,5), is(-1));
        assertThat(numArray.sumRange(0,2), is(1));
        assertThat(numArray.sumRange(2,5), is(-1));
        assertThat(numArray.sumRange(1,5), is(-1));
        assertThat(numArray.sumRange(2,5), is(-1));
        assertThat(numArray.sumRange(3,5), is(-4));
        assertThat(numArray.sumRange(0,5), is(-3));
    }

    @Test
    public void shouldPassEmptyTest() throws Exception {
        new RangeSumQueryImmutable().new NumArray(new int[]{});
    }
}