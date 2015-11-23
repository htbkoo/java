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
public class DivideTwoIntegersTest {
    private enum ParameterType {
        DIVIDEND, DIVISOR, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.DIVIDEND, 0,
                        ParameterType.DIVISOR, 1,
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.DIVIDEND, 1,
                        ParameterType.DIVISOR, 0,
                        ParameterType.ANSWER, Integer.MAX_VALUE
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.DIVIDEND, 1,
                        ParameterType.DIVISOR, 1,
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.DIVIDEND, 2,
                        ParameterType.DIVISOR, 1,
                        ParameterType.ANSWER, 2
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.DIVIDEND, 1,
                        ParameterType.DIVISOR, 2,
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.DIVIDEND, 981,
                        ParameterType.DIVISOR, 30,
                        ParameterType.ANSWER, 32
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.DIVIDEND, 990,
                        ParameterType.DIVISOR, 30,
                        ParameterType.ANSWER, 33
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.DIVIDEND, -2147483648,
                        ParameterType.DIVISOR, -1,
                        ParameterType.ANSWER, 2147483647
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.DIVIDEND, -2147483648,
                        ParameterType.DIVISOR, -2,
                        ParameterType.ANSWER, 1073741824
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.DIVIDEND, -2147483648,
                        ParameterType.DIVISOR, -3,
                        ParameterType.ANSWER, 715827882
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.DIVIDEND, -1010369383,
                        ParameterType.DIVISOR, -2147483648,
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.DIVIDEND, -2147483648,
                        ParameterType.DIVISOR, 1,
                        ParameterType.ANSWER, -2147483648
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.DIVIDEND, 101,
                        ParameterType.DIVISOR, 11,
                        ParameterType.ANSWER, 9
                )});
    }

    private int fInputDividend;
    private int fInputDivisor;
    private int fExpected;

    public DivideTwoIntegersTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputDividend = (int) parametersMap.get(ParameterType.DIVIDEND);
        fInputDivisor = (int) parametersMap.get(ParameterType.DIVISOR);
        fExpected = (int) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldDivide() {
        try {
            assertEquals(fExpected, new DivideTwoIntegers().divide(fInputDividend, fInputDivisor));
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }

}