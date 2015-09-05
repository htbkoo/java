package lambda.practice.one;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//@RunWith()
public class PracticeTest {

    Practice practice;

    @Before
    public void setUp() throws Exception {
        practice = new Practice();
    }

    @Test
    public void shouldGetLambdaResult() throws Exception {
        assertEquals("a", practice.getLambdaResult());
    }
}