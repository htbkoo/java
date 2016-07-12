package online.codewars._5kyu;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static online.codewars._5kyu.CommonDenominators.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Hey on 9 Jul 2016
 */
@RunWith(Parameterized.class)
public class CommonDenominatorsTest {

    final private long[][] lst;
    final private String expected;

    @Parameterized.Parameters(name = "[{0}] Fracts.convertFrac({1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{
                        "given test case",
                        new long[][]{{1, 2}, {1, 3}, {1, 4}},
                        "(6,12)(4,12)(3,12)"
                },
                new Object[]{
                        "empty test case",
                        new long[][]{},
                        ""
                },
                new Object[]{
                        "one test case",
                        new long[][]{{1, 2}},
                        "(1,2)"
                }
        );
    }

    public CommonDenominatorsTest(String name, long[][] lst, String expected) {
        this.lst = lst;
        this.expected = expected;
    }

    @Test
    public void shouldConvertFrac() throws Exception {
        assertThat(Fracts.convertFrac(lst), is(expected));
    }

    @Ignore
    @Test
    public void test_fractions() throws Exception {
        long[][] lst;
        lst = new long[][]{{1, 2}, {1, 3}, {1, 4}};
        assertEquals("(6,12)(4,12)(3,12)", Fracts.convertFrac(lst));
    }
}