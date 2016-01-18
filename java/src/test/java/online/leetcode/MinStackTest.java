package online.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Hey on 17/1/16
 */
public class MinStackTest {
    MinStack minStack;

    @Before
    public void setUp() throws Exception {
        minStack = new MinStack();
    }

    @Test
    public void shouldTestMinStack() throws Exception {
        minStack.push(10);
        assertThat(minStack.top(), is(10));
        assertThat(minStack.getMin(), is(10));

        minStack.push(12);
        assertThat(minStack.top(), is(12));
        assertThat(minStack.getMin(), is(10));

        minStack.pop();
        assertThat(minStack.top(), is(10));
        assertThat(minStack.getMin(), is(10));

        minStack.push(5);
        assertThat(minStack.top(), is(5));
        assertThat(minStack.getMin(), is(5));

        minStack.push(1);
        assertThat(minStack.top(), is(1));
        assertThat(minStack.getMin(), is(1));

        minStack.pop();
        assertThat(minStack.top(), is(5));
        assertThat(minStack.getMin(), is(5));

        minStack.pop();
        assertThat(minStack.top(), is(10));
        assertThat(minStack.getMin(), is(10));

        minStack.pop();
    }

    @Test
    public void bulkyTestCase() throws Exception {
        for (int i = -10000; i <= 5000; ++i) {
            minStack.push(i);
        }
        for (int i = -10000; i < 0; ++i) {
            assertThat(minStack.getMin(), is(-10000));
            minStack.pop();
        }
    }
}