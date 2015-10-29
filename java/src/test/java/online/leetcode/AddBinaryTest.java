package online.leetcode;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hey on 19/10/15
 */
@RunWith(Parameterized.class)
public class AddBinaryTest {
    private enum ParameterType {
        A, B, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.A, "0",
                        ParameterType.B, "0",
                        ParameterType.ANSWER, "0"
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.A, "1",
                        ParameterType.B, "0",
                        ParameterType.ANSWER, "1"
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.A, "1",
                        ParameterType.B, "0",
                        ParameterType.ANSWER, "1"
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.A, "1",
                        ParameterType.B, "0",
                        ParameterType.ANSWER, "1"
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.A, "10101000",
                        ParameterType.B, "10001010",
                        ParameterType.ANSWER, "100110010"
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.A, "10101000",
                        ParameterType.B, "110001010",
                        ParameterType.ANSWER, "1000110010"
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.A, "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                        ParameterType.B, "0",
                        ParameterType.ANSWER, "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.A, "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                        ParameterType.B, "1",
                        ParameterType.ANSWER, "100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.A, "101",
                        ParameterType.B, "11",
                        ParameterType.ANSWER, "1000"
                )});
    }

    private String fInputA;
    private String fInputB;
    private String fExpected;

    public AddBinaryTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputA = (String) parametersMap.get(ParameterType.A);
        fInputB = (String) parametersMap.get(ParameterType.B);
        fExpected = (String) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldFindSingleNumber() {
        assertEquals(fExpected, new AddBinary().addBinary(fInputA, fInputB));
    }

    @Test
    public void shouldFindSingleNumberUsingParseLongButFailedDueToOverflow() {
        try {
            assertEquals(fExpected, new AddBinary.WrongAttempt().addBinary(fInputA, fInputB));
        } catch (NumberFormatException e) {
            assertTrue(e.getMessage().contains(fInputA));
        }
    }
}