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
public class PowXNTest {
    private enum ParameterType {
        X, N, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.X, 0.0,
                        ParameterType.N, 1,
                        ParameterType.ANSWER, 0.0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.X, 1.0,
                        ParameterType.N, 0,
                        ParameterType.ANSWER, 1.0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.X, 1.0,
                        ParameterType.N, 1,
                        ParameterType.ANSWER, 1.0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.X, 2.0,
                        ParameterType.N, 1,
                        ParameterType.ANSWER, 2.0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.X, 1.0,
                        ParameterType.N, 2,
                        ParameterType.ANSWER, 1.0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.X, 98.1,
                        ParameterType.N, 3,
                        ParameterType.ANSWER, 944076.141
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.X, 8.88023,
                        ParameterType.N, 3,
                        ParameterType.ANSWER, 700.28148
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.X, 34.00515,
                        ParameterType.N, -3,
                        ParameterType.ANSWER, 0.00003
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.X, 34.00515,
                        ParameterType.N, -3,
                        ParameterType.ANSWER, 0.00003
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.X, 0.00001,
                        ParameterType.N, 2147483647,
                        ParameterType.ANSWER, 0.00003
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.X, 10.3,
                        ParameterType.N, 4,
                        ParameterType.ANSWER, 11255.0881
                )});
    }

    private double fInputX;
    private int fInputN;
    private double fExpected;

    public PowXNTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputX = (double) parametersMap.get(ParameterType.X);
        fInputN = (int) parametersMap.get(ParameterType.N);
        fExpected = (double) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldGetMyPow() {
        assertEquals(fExpected, new PowXN().myPow(fInputX, fInputN), 0.0001);
    }

}