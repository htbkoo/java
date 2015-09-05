package lambda.practice.one;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
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

    @Test
    public void shouldTransformListToMap() throws Exception {

//        assertEquals();

    }
}