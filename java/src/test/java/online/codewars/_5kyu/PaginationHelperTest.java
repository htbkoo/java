package online.codewars._5kyu;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Hey on 21 Jul 2016
 */

// DONE: Replace examples and use TDD development by writing your own tests

public class PaginationHelperTest {
    @Test
    public void testSomething() {
        PaginationHelper<Character> helper = new PaginationHelper<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        assertThat(helper.pageCount(), is(2));
        assertThat(helper.itemCount(), is(6));
        assertThat(helper.pageItemCount(0), is(4));
        assertThat(helper.pageItemCount(1), is(2));
        assertThat(helper.pageItemCount(2), is(-1));

        // pageIndex takes an item index and returns the page that it belongs on
        assertThat(helper.pageIndex(5), is(1));
        assertThat(helper.pageIndex(2), is(0));
        assertThat(helper.pageIndex(20), is(-1));
        assertThat(helper.pageIndex(-10), is(-1));

        PaginationHelper<Character> helper2 = new PaginationHelper<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n'), 5);
        assertThat(helper2.pageItemCount(0), is(5));
        assertThat(helper2.pageItemCount(1), is(5));
        assertThat(helper2.pageItemCount(2), is(4));
        assertThat(helper2.pageItemCount(3), is(-1));

        PaginationHelper<Character> helper3 = new PaginationHelper<>(Arrays.asList('a', 'b'), 2);
        assertThat(helper3.pageItemCount(0), is(2));
        assertThat(helper3.pageItemCount(1), is(-1));
    }
}