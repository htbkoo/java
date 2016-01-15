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
 * Created by Hey on 14/1/16
 */
@RunWith(Parameterized.class)
public class BullsAndCowsTest {
    private enum ParameterType {
        SECRET, GUESS, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.SECRET, "1807",
                        ParameterType.GUESS, "7810",
                        ParameterType.ANSWER, "1A3B"
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.SECRET, "1123",
                        ParameterType.GUESS, "0111",
                        ParameterType.ANSWER, "1A1B"
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.SECRET, "180505046494875847",
                        ParameterType.GUESS, "781576595050857430",
                        ParameterType.ANSWER, "3A11B"
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.SECRET, "",
                        ParameterType.GUESS, "",
                        ParameterType.ANSWER, "0A0B"
                )});
    }

    private String fInputSecret;
    private String fInputGuess;
    private String fExpected;

    public BullsAndCowsTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputSecret = (String) parametersMap.get(ParameterType.SECRET);
        fInputGuess = (String) parametersMap.get(ParameterType.GUESS);
        fExpected = (String) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldCheckIsIsomorphic() {
        assertEquals(fExpected, new BullsAndCows().getHint(fInputSecret, fInputGuess));
    }

}