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
 * Created by Hey on 29/10/15
 */
@RunWith(Parameterized.class)
public class SearchInsertPositionTest {
    private enum ParameterType {
        NUMS, TARGET, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{},
                        ParameterType.TARGET, 0,
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1},
                        ParameterType.TARGET, 0,
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1},
                        ParameterType.TARGET, 1,
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1},
                        ParameterType.TARGET, 2,
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{0, 1, 2},
                        ParameterType.TARGET, 1,
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 2, 3, 3, 4, 5},
                        ParameterType.TARGET, 0,
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 3, 5, 6},
                        ParameterType.TARGET, 0,
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 3, 5, 6},
                        ParameterType.TARGET, 1,
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 3, 5, 6},
                        ParameterType.TARGET, 2,
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 3, 5, 6},
                        ParameterType.TARGET, 3,
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 3, 5, 6},
                        ParameterType.TARGET, 4,
                        ParameterType.ANSWER, 2
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 3, 5, 6},
                        ParameterType.TARGET, 5,
                        ParameterType.ANSWER, 2
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 3, 5, 6},
                        ParameterType.TARGET, 6,
                        ParameterType.ANSWER, 3
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 3, 5, 6},
                        ParameterType.TARGET, 7,
                        ParameterType.ANSWER, 4
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 3, 5, 6},
                        ParameterType.TARGET, 8,
                        ParameterType.ANSWER, 4
                )});
    }

    private int[] fInputNums;
    private int fTarget;
    private int fExpected;

    public SearchInsertPositionTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputNums = (int[]) parametersMap.get(ParameterType.NUMS);
        fTarget = (int) parametersMap.get(ParameterType.TARGET);
        fExpected = (int) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldSearchInsertPosition() {
        assertEquals(fExpected, new SearchInsertPosition().searchInsert(fInputNums, fTarget));
    }

}