package online.codewars._6kyu;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static online.codewars._6kyu.TriangleNumberCheck.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Hey on 17 Jul 2016
 */
@RunWith(Parameterized.class)
public class TriangleNumberCheckTest {

    final private int fNumber;
    final private Boolean fExpected;

    @Parameterized.Parameters(name = "[{0}] TriangleNumbers.isTriangleNumber({1})={2} ")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{"test 1", 125250, true},
                new Object[]{"test 2", 3126250, true},
                new Object[]{"example 1", 0, true},
                new Object[]{"example 2", 1, true},
                new Object[]{"example 3", 3, true},
                new Object[]{"example 4", 6, true},
                new Object[]{"example 5", 10, true},
                new Object[]{"example 6", 15, true},
                new Object[]{"example 7", 2, false},
                new Object[]{"example 8", 4, false},
                new Object[]{"example 9", 8, false},
                new Object[]{"example 10", 16, false}
        );
    }

    public TriangleNumberCheckTest(@SuppressWarnings("UnusedParameters") String name, int fNumber, Boolean fExpected) {
        this.fNumber = fNumber;
        this.fExpected = fExpected;
    }

    @Test
    public void shouldCheckIsTriangleNumber() throws Exception {
        assertThat(TriangleNumbers.isTriangleNumber(fNumber), is(fExpected));
    }

    @Ignore
    @Test
    public void test1() {
        assertEquals(TriangleNumbers.isTriangleNumber(125250), true);
    }

    @Ignore
    @Test
    public void test2() {
        assertEquals(TriangleNumbers.isTriangleNumber(3126250), true);
    }
}