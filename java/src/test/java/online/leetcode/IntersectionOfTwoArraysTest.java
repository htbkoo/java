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
 * Created by Hey on 31 May 2016
 */
@RunWith(Parameterized.class)
public class IntersectionOfTwoArraysTest {
    private enum ParameterType {
        NUMS1, NUMS2, ANSWER
    }

    private static int[] initializeIntegerArray(int[] destArray, int... varargs) {
        final int length = varargs.length;
        System.arraycopy(varargs, 0, destArray, 0, length);
        return destArray;
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS1, new int[]{},
                        ParameterType.NUMS2, new int[]{},
                        ParameterType.ANSWER, new int[]{}
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS1, new int[]{1},
                        ParameterType.NUMS2, new int[]{},
                        ParameterType.ANSWER, new int[]{}
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS1, new int[]{},
                        ParameterType.NUMS2, new int[]{1},
                        ParameterType.ANSWER, new int[]{}
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS1, new int[]{1},
                        ParameterType.NUMS2, new int[]{1,1},
                        ParameterType.ANSWER, new int[]{1}
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS1, new int[]{1, 2, 3},
                        ParameterType.NUMS2, new int[]{1},
                        ParameterType.ANSWER, new int[]{1}
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS1, new int[]{1, 2, 2, 1},
                        ParameterType.NUMS2, new int[]{2},
                        ParameterType.ANSWER, new int[]{2}
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS1, new int[]{1, 3, 7},
                        ParameterType.NUMS2, new int[]{2, 3, 4, 5, 6, 7, 10},
                        ParameterType.ANSWER, new int[]{3, 7}
                )});
    }

    private int[] fInputNums1;
    private int[] fInputNums2;
    private int[] fExpected;

    public IntersectionOfTwoArraysTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputNums1 = (int[]) parametersMap.get(ParameterType.NUMS1);
        fInputNums2 = (int[]) parametersMap.get(ParameterType.NUMS2);
        fExpected = (int[]) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldMergeSortedArray() {
        assertArrayEquals(fExpected, new IntersectionOfTwoArrays().intersection(fInputNums1, fInputNums2));
    }

}