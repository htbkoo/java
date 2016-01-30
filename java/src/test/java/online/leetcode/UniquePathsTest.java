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
 * Created by Hey on 30/1/16
 */
@RunWith(Parameterized.class)
public class UniquePathsTest {
    private enum ParameterType {
        M, N, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.M, 1,
                        ParameterType.N, 2,
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.M, 3,
                        ParameterType.N, 7,
                        ParameterType.ANSWER, 28
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.M, 1,
                        ParameterType.N, 1,
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.M, 2,
                        ParameterType.N, 1,
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.M, 5,
                        ParameterType.N, 8,
                        ParameterType.ANSWER, 330
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.M, 98,
                        ParameterType.N, 30,
                        ParameterType.ANSWER, 268974418
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.M, 11,
                        ParameterType.N, 11,
                        ParameterType.ANSWER, 184756
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.M, 33,
                        ParameterType.N, 33,
                        ParameterType.ANSWER, 1336951366
                )});
    }

    private int fInputM;
    private int fInputN;
    private int fExpected;

    public UniquePathsTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputM = (int) parametersMap.get(ParameterType.M);
        fInputN = (int) parametersMap.get(ParameterType.N);
        fExpected = (int) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldGetNumberOfUniquePaths() {
        assertEquals(fExpected, new UniquePaths().uniquePaths(fInputM, fInputN));
    }

}