package online.leetcode;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Hey on 19/10/15
 */
@RunWith(Parameterized.class)
public class TwoSumTest {
    private enum ParameterType {
        NUMS, TARGET, ANSWER
    }

    private static int[] createAnswer(int first, int second) {
        return new int[]{first, second};
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{3, 2, 4},
                        ParameterType.TARGET, 6,
                        ParameterType.ANSWER, createAnswer(2, 3)
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{2, 7, 11, 15},
                        ParameterType.TARGET, 9,
                        ParameterType.ANSWER, createAnswer(1, 2)
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 2, 3, 4, 5, 7, 11, 15},
                        ParameterType.TARGET, 13,
                        ParameterType.ANSWER, createAnswer(2, 7)
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 2, 3, 4, 5, 7, 11, 15},
                        ParameterType.TARGET, 14,
                        ParameterType.ANSWER, createAnswer(3, 7)
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 2, 3, 4, 5, 7, 11, 15},
                        ParameterType.TARGET, 10,
                        ParameterType.ANSWER, createAnswer(3, 6)
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{2, 3, 4, 5, 7, 11, 15},
                        ParameterType.TARGET, 8,
                        ParameterType.ANSWER, createAnswer(2, 4)
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 2, 3, 4, 5, 7, 11, 15},
                        ParameterType.TARGET, 6,
                        ParameterType.ANSWER, createAnswer(1, 5)
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS, new int[]{1, 2, 4, 5, 7, 11, 15},
                        ParameterType.TARGET, 8,
                        ParameterType.ANSWER, createAnswer(1, 5)
                )});
    }

    private int[] fInputNums;
    private int fInputTarget;
    private int[] fExpected;

    public TwoSumTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputNums = (int[]) parametersMap.get(ParameterType.NUMS);
        fInputTarget = (int) parametersMap.get(ParameterType.TARGET);
        fExpected = (int[]) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldGetTwoSum() {
        assertArrayEquals(fExpected, new TwoSum().twoSum(fInputNums, fInputTarget));
    }

}