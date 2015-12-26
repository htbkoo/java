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
 * Created by Hey on 7/12/15
 */
@RunWith(Parameterized.class)
public class MergeSortedArrayTest {
    private enum ParameterType {
        NUMS1, M, NUMS2, N, ANSWER
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
                        ParameterType.M, 0,
                        ParameterType.NUMS2, new int[]{},
                        ParameterType.N, 0,
                        ParameterType.ANSWER, new int[]{}
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS1, new int[]{1},
                        ParameterType.M, 1,
                        ParameterType.NUMS2, new int[]{},
                        ParameterType.N, 0,
                        ParameterType.ANSWER, new int[]{1}
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS1, initializeIntegerArray(new int[1]),
                        ParameterType.M, 0,
                        ParameterType.NUMS2, new int[]{1},
                        ParameterType.N, 1,
                        ParameterType.ANSWER, new int[]{1}
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS1, initializeIntegerArray(new int[2], 1),
                        ParameterType.M, 1,
                        ParameterType.NUMS2, new int[]{1},
                        ParameterType.N, 1,
                        ParameterType.ANSWER, new int[]{1, 1}
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.NUMS1, initializeIntegerArray(new int[10], 1, 3, 7),
                        ParameterType.M, 3,
                        ParameterType.NUMS2, new int[]{2, 3, 4, 5, 6, 7, 10},
                        ParameterType.N, 7,
                        ParameterType.ANSWER, new int[]{1, 2, 3, 3, 4, 5, 6, 7, 7, 10}
                )});
    }

    private int[] fInputNums1;
    private int fInputM;
    private int[] fInputNums2;
    private int fInputN;
    private int[] fExpected;

    public MergeSortedArrayTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputNums1 = (int[]) parametersMap.get(ParameterType.NUMS1);
        fInputM = (int) parametersMap.get(ParameterType.M);
        fInputNums2 = (int[]) parametersMap.get(ParameterType.NUMS2);
        fInputN = (int) parametersMap.get(ParameterType.N);
        fExpected = (int[]) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldMergeSortedArray() {
        new MergeSortedArray().merge(fInputNums1, fInputM, fInputNums2, fInputN);
        assertArrayEquals(fExpected, Arrays.copyOf(fInputNums1, fExpected.length));
    }

}