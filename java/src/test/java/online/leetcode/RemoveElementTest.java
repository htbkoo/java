package online.leetcode;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 29/10/15
 */
@RunWith(Parameterized.class)
public class RemoveElementTest {
    private enum ParameterType {
        NUMS, VALUE, OUTPUT_NUMS, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{},
                        ParameterType.OUTPUT_NUMS, new int[]{},
                        ParameterType.VALUE, 0,
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1},
                        ParameterType.OUTPUT_NUMS, new int[]{1},
                        ParameterType.VALUE, 0,
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1},
                        ParameterType.OUTPUT_NUMS, new int[]{},
                        ParameterType.VALUE, 1,
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 1, 2},
                        ParameterType.OUTPUT_NUMS, new int[]{2},
                        ParameterType.VALUE, 1,
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 1, 2, 3, 3, 4, 5},
                        ParameterType.OUTPUT_NUMS, new int[]{1, 1, 2, 3, 3, 4, 5},
                        ParameterType.VALUE, 0,
                        ParameterType.ANSWER, 7
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 4, 1, 3, 5, 2, 3},
                        ParameterType.OUTPUT_NUMS, new int[]{4, 3, 5, 2, 3},
                        ParameterType.VALUE, 1,
                        ParameterType.ANSWER, 5
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 4, 1, 3, 5, 2, 3},
                        ParameterType.OUTPUT_NUMS, new int[]{1, 4, 1, 3, 5, 3},
                        ParameterType.VALUE, 2,
                        ParameterType.ANSWER, 6
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 4, 1, 3, 5, 2, 3},
                        ParameterType.OUTPUT_NUMS, new int[]{1, 4, 1, 5, 2},
                        ParameterType.VALUE, 3,
                        ParameterType.ANSWER, 5
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{-2, -2, -1, 0, 4},
                        ParameterType.OUTPUT_NUMS, new int[]{-2, -2, -1, 4},
                        ParameterType.VALUE, 0,
                        ParameterType.ANSWER, 4
                )});
    }

    private int[] fInputNums;
    private int fValue;
    private int[] fOutputNums;
    private int fExpected;

    public RemoveElementTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputNums = (int[]) parametersMap.get(ParameterType.NUMS);
        fValue = (int) parametersMap.get(ParameterType.VALUE);
        fOutputNums = (int[]) parametersMap.get(ParameterType.OUTPUT_NUMS);
        fExpected = (int) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldRemoveElement() {
        assertEquals(fExpected, new RemoveElement().removeElement(fInputNums, fValue));
        assertArrayEquals(fOutputNums, Arrays.copyOf(fInputNums, fExpected));
    }

}