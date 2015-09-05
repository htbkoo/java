package lambda.practice.one;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Map;

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
        Map map = ImmutableMap.of(1, "a", 2, "b");
        List<Object> list = Lists.newArrayList("a", "b");

        assertEquals(map, practice.transformList(list));

    }
}