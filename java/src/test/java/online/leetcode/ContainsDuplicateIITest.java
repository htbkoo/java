package online.leetcode;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.ArrayUtils;
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
public class ContainsDuplicateIITest {
    private enum ParameterType {
        NUMS, K, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new Integer[]{},
                        ParameterType.K, 0,
                        ParameterType.ANSWER, false
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new Integer[]{1,2,3,4,5},
                        ParameterType.K, 2,
                        ParameterType.ANSWER, false
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new Integer[]{1,2,3,4,2},
                        ParameterType.K, 2,
                        ParameterType.ANSWER, false
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new Integer[]{1,2,3,2,5},
                        ParameterType.K, 2,
                        ParameterType.ANSWER, true
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new Integer[]{1,1,1,1},
                        ParameterType.K, 1,
                        ParameterType.ANSWER, true
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new Integer[]{1,3,5,7,9,11,13,15,1,2,3,4},
                        ParameterType.K, 8,
                        ParameterType.ANSWER, true
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new Integer[]{1,3,5,7,9,11,13,15,1,2,3,4},
                        ParameterType.K, 7,
                        ParameterType.ANSWER, false
                )});
    }

    private int[] fInput;
    private int fK;
    private boolean fExpected;

    public ContainsDuplicateIITest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInput = ArrayUtils.toPrimitive((Integer[]) parametersMap.get(ParameterType.NUMS));
        fK = (int) parametersMap.get(ParameterType.K);
        fExpected = (boolean) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldFindSingleNumber() {
        assertEquals(fExpected, new ContainsDuplicateII().containsNearbyDuplicate(fInput, fK));
    }
}