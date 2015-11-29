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
 * Created by Hey on 19/10/15
 */
@RunWith(Parameterized.class)
public class RemoveDuplicatesFromSortedArrayTest {
    private enum ParameterType {
        NUMS, OUTPUT_NUMS, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{},
                        ParameterType.OUTPUT_NUMS, new int[]{},
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1},
                        ParameterType.OUTPUT_NUMS, new int[]{1},
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 1, 2},
                        ParameterType.OUTPUT_NUMS, new int[]{1, 2},
                        ParameterType.ANSWER, 2
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 1, 2, 3, 3, 4, 5},
                        ParameterType.OUTPUT_NUMS, new int[]{1, 2, 3, 4, 5},
                        ParameterType.ANSWER, 5
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{-2, -2, -1, 0, 4},
                        ParameterType.OUTPUT_NUMS, new int[]{-2, -1, 0, 4},
                        ParameterType.ANSWER, 4
                )});
    }

    private int[] fInputNums;
    private int[] fOutputNums;
    private int fExpected;

    public RemoveDuplicatesFromSortedArrayTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputNums = (int[]) parametersMap.get(ParameterType.NUMS);
        fOutputNums = (int[]) parametersMap.get(ParameterType.OUTPUT_NUMS);
        fExpected = (int) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldRemoveDuplicates() {
        assertEquals(fExpected, new RemoveDuplicatesFromSortedArray().removeDuplicates(fInputNums));
        assertArrayEquals(fOutputNums, Arrays.copyOf(fInputNums, fExpected));
    }

}