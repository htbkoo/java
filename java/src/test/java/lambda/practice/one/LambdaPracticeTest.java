package lambda.practice.one;

import com.google.common.collect.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LambdaPracticeTest {

    LambdaPractice lambdaPractice;

    @Before
    public void setUp() throws Exception {
        lambdaPractice = new LambdaPractice();
    }

    @Test
    public void shouldGetLambdaResult() throws Exception {
        assertEquals("a", lambdaPractice.getLambdaResult());
    }

    @Test
    public void shouldTransformListToMapAsKey() throws Exception {
        Map map = ImmutableMap.of("a", "a_value", "b", "b_value");
        List<Object> list = Lists.newArrayList("a", "b");

        assertEquals(map, lambdaPractice.transformList(list));
    }

    private class testValueObject {
        private final String key;
        private final String value;

        private testValueObject(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder()
                    .append(key)
                    .append(value)
                    .build();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof testValueObject) {
                testValueObject t = (testValueObject) o;
                return new EqualsBuilder()
                        .append(this.key, t.key)
                        .append(this.value, t.value)
                        .build();
            } else {
                return false;
            }
        }
    }

    @Test
    public void shouldTransformListToMapAsValue() throws Exception {
        testValueObject a = new testValueObject("1", "a");
        testValueObject b = new testValueObject("2", "b");

        ArrayListMultimap<Object, Object> map = ArrayListMultimap.create();
        map.put("1", a);
        map.put("2", b);
        List<testValueObject> list = Lists.newArrayList(a, b);

        assertEquals(map, lambdaPractice.transformListAsValue(list, testValueObject::getKey));
    }
}