package online.leetcode;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 19/10/15
 */
@RunWith(Parameterized.class)
public class WordPatternTest {
    private enum ParameterType {
        PATTERN, STR, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.PATTERN, "abba",
                        ParameterType.STR, "dog cat cat dog",
                        ParameterType.ANSWER, true
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.PATTERN, "abba",
                        ParameterType.STR, "dog cat cat fish",
                        ParameterType.ANSWER, false
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.PATTERN, "aaaa",
                        ParameterType.STR, "dog cat cat fish",
                        ParameterType.ANSWER, false
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.PATTERN, "abba",
                        ParameterType.STR, "dog dog dog dog",
                        ParameterType.ANSWER, false
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.PATTERN, "",
                        ParameterType.STR, "",
                        ParameterType.ANSWER, false
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.PATTERN, "a",
                        ParameterType.STR, "s ",
                        ParameterType.ANSWER, true
                )});
    }

    private String fPattern;
    private String fStr;
    private boolean fExpected;

    public WordPatternTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fPattern = (String) parametersMap.get(ParameterType.PATTERN);
        fStr = (String) parametersMap.get(ParameterType.STR);
        fExpected = (boolean) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldCheckIsWordPattern() {
        assertEquals(fExpected, new WordPattern().wordPattern(fPattern, fStr));
    }
}