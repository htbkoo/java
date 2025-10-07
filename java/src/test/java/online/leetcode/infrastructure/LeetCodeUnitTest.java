package online.leetcode.infrastructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Hey on 7-Oct-2025
 * <p>
 * The unit test infrastructure for the LeetCode problems
 * <p>
 * Update: migrating to composition instead of inheritance
 */
@RunWith(Parameterized.class)
public abstract class LeetCodeUnitTest<I, E> {

    private final I fInput;
    private final E fExpected;

    public LeetCodeUnitTest(I input, E expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Test
    public void shouldGetExpectedResult() {
        assertThat(getActual(), is(fExpected));
    }

    protected abstract E getActual();

    protected I getInput() {
        return fInput;
    }
}
