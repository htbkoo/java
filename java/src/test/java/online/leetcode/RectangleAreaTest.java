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
 * Created by Hey on 7/12/15
 */
@RunWith(Parameterized.class)
public class RectangleAreaTest {
    private enum ParameterType {
        A, B, C, D, E, F, G, H, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.builder()
                        .put(ParameterType.A, 0)
                        .put(ParameterType.B, 1)
                        .put(ParameterType.C, 0)
                        .put(ParameterType.D, 1)
                        .put(ParameterType.E, 0)
                        .put(ParameterType.F, 1)
                        .put(ParameterType.G, 0)
                        .put(ParameterType.H, 1)
                        .put(ParameterType.ANSWER, 0)
                        .build()},
                new Map[]{ImmutableMap.builder()
                        .put(ParameterType.A, 0)
                        .put(ParameterType.B, 1)
                        .put(ParameterType.C, 1)
                        .put(ParameterType.D, 2)
                        .put(ParameterType.E, 0)
                        .put(ParameterType.F, 1)
                        .put(ParameterType.G, 1)
                        .put(ParameterType.H, 2)
                        .put(ParameterType.ANSWER, 1)
                        .build()},
                new Map[]{ImmutableMap.builder()
                        .put(ParameterType.A, 0)
                        .put(ParameterType.B, 1)
                        .put(ParameterType.C, 1)
                        .put(ParameterType.D, 2)
                        .put(ParameterType.E, 1)
                        .put(ParameterType.F, 2)
                        .put(ParameterType.G, 2)
                        .put(ParameterType.H, 3)
                        .put(ParameterType.ANSWER, 2)
                        .build()},
                new Map[]{ImmutableMap.builder()
                        .put(ParameterType.A, -2)
                        .put(ParameterType.B, -2)
                        .put(ParameterType.C, 2)
                        .put(ParameterType.D, 2)
                        .put(ParameterType.E, -2)
                        .put(ParameterType.F, -2)
                        .put(ParameterType.G, 2)
                        .put(ParameterType.H, 2)
                        .put(ParameterType.ANSWER, 16)
                        .build()},
                new Map[]{ImmutableMap.builder()
                        .put(ParameterType.A, -3)
                        .put(ParameterType.B, 0)
                        .put(ParameterType.C, 3)
                        .put(ParameterType.D, 4)
                        .put(ParameterType.E, 0)
                        .put(ParameterType.F, -1)
                        .put(ParameterType.G, 9)
                        .put(ParameterType.H, 2)
                        .put(ParameterType.ANSWER, 45)
                        .build()},
                new Map[]{ImmutableMap.builder()
                        .put(ParameterType.A, -3)
                        .put(ParameterType.B, 0)
                        .put(ParameterType.C, 3)
                        .put(ParameterType.D, 4)
                        .put(ParameterType.E, -1)
                        .put(ParameterType.F, 0)
                        .put(ParameterType.G, 9)
                        .put(ParameterType.H, 2)
                        .put(ParameterType.ANSWER, 36)
                        .build()}
        );
    }

    private int fInputA;
    private int fInputB;
    private int fInputC;
    private int fInputD;
    private int fInputE;
    private int fInputF;
    private int fInputG;
    private int fInputH;
    private int fExpected;

    public RectangleAreaTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputA = (int) parametersMap.get(ParameterType.A);
        fInputB = (int) parametersMap.get(ParameterType.B);
        fInputC = (int) parametersMap.get(ParameterType.C);
        fInputD = (int) parametersMap.get(ParameterType.D);
        fInputE = (int) parametersMap.get(ParameterType.E);
        fInputF = (int) parametersMap.get(ParameterType.F);
        fInputG = (int) parametersMap.get(ParameterType.G);
        fInputH = (int) parametersMap.get(ParameterType.H);
        fExpected = (int) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldComputeArea() {
        assertEquals(fExpected, new RectangleArea().computeArea(fInputA, fInputB, fInputC, fInputD, fInputE, fInputF, fInputG, fInputH));
    }
}