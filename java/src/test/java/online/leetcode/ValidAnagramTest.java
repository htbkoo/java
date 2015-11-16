package online.leetcode;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 19/10/15
 */
@RunWith(Parameterized.class)
public class ValidAnagramTest {
    private enum ParameterType {
        S, T, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.S, "anagram",
                        ParameterType.T, "nagaram",
                        ParameterType.ANSWER, TRUE
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.S, "rat",
                        ParameterType.T, "car",
                        ParameterType.ANSWER, FALSE
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.S, "ababa",
                        ParameterType.T, "aba",
                        ParameterType.ANSWER, FALSE
                )}
        );
    }

    private String fInputA;
    private String fInputB;
    private Boolean fExpected;

    public ValidAnagramTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputA = (String) parametersMap.get(ParameterType.S);
        fInputB = (String) parametersMap.get(ParameterType.T);
        fExpected = (Boolean) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldCheckIsAnagram() {
        assertEquals(fExpected, new ValidAnagram().isAnagram(fInputA, fInputB));
    }
}