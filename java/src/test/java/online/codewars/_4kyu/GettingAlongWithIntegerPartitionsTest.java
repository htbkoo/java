package online.codewars._4kyu;

import online.codewars._4kyu.GettingAlongWithIntegerPartitions.IntPart;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Hey on 10 Oct 2016
 */
@RunWith(Parameterized.class)
public class GettingAlongWithIntegerPartitionsTest {

    private final String expected;
    private final long fInput;

    @Parameterized.Parameters(name = "[{0}]IntPart.part({1})=\"{2}\"")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{"Given Test 0", 2L, "Range: 1 Average: 1.50 Median: 1.50"},
                new Object[]{"Given Test 1", 3L, "Range: 2 Average: 2.00 Median: 2.00"},
                new Object[]{"Given Test 2", 4L, "Range: 3 Average: 2.50 Median: 2.50"},
                new Object[]{"Given Test 3", 5L, "Range: 5 Average: 3.50 Median: 3.50"},
                new Object[]{"Given Test 4", 8L, "Range: 17 Average: 8.29 Median: 7.50"}
        );
    }

    public GettingAlongWithIntegerPartitionsTest(@SuppressWarnings("UnusedParameters") String name, long fInput, String expected) {
        this.fInput = fInput;
        this.expected = expected;
    }

    @Ignore
    @Test
    public void Numbers_Small() {
        assertEquals("Range: 1 Average: 1.50 Median: 1.50", IntPart.part(2));
        assertEquals("Range: 2 Average: 2.00 Median: 2.00", IntPart.part(3));
        assertEquals("Range: 3 Average: 2.50 Median: 2.50", IntPart.part(4));
        assertEquals("Range: 5 Average: 3.50 Median: 3.50", IntPart.part(5));
    }

    @Test
    public void shouldTestIntPart() {
        assertThat(IntPart.part(fInput), is(expected));
    }
}