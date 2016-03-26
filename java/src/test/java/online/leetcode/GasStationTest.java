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
 * Created by Hey on 27/3/16
 */
@RunWith(Parameterized.class)
public class GasStationTest {
    private enum ParameterType {
        GAS, COST, ANSWER
    }

    private static int[] createAnswer(int first, int second) {
        return new int[]{first, second};
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{4},
                        ParameterType.COST,new int[]{5},
                        ParameterType.ANSWER, -1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{0},
                        ParameterType.COST, new int[]{0},
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{},
                        ParameterType.COST, new int[]{},
                        ParameterType.ANSWER, -1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{0,10},
                        ParameterType.COST, new int[]{11,3},
                        ParameterType.ANSWER, -1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{0,10},
                        ParameterType.COST, new int[]{8,3},
                        ParameterType.ANSWER, -1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{0,10},
                        ParameterType.COST, new int[]{7,3},
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{6,1,4,3,5},
                        ParameterType.COST, new int[]{3,8,2,4,2},
                        ParameterType.ANSWER, 2
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{3,5,6,1,4},
                        ParameterType.COST, new int[]{4,2,3,8,2},
                        ParameterType.ANSWER, 4
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{4,3,5,6,1},
                        ParameterType.COST, new int[]{2,4,2,3,8},
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{1,2,3,4,5},
                        ParameterType.COST, new int[]{3,4,5,1,2},
                        ParameterType.ANSWER, 3
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{1,2,3,4,5},
                        ParameterType.COST, new int[]{3,3,5,1,2},
                        ParameterType.ANSWER, 3
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{2,3,1},
                        ParameterType.COST, new int[]{3,1,2},
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{2,4,1,0},
                        ParameterType.COST, new int[]{3,1,2,0},
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{2,4,0,1,0},
                        ParameterType.COST, new int[]{3,1,0,2,0},
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{0,2,2,2,2},
                        ParameterType.COST, new int[]{4,1,1,1,1},
                        ParameterType.ANSWER, 1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{0,0,3,2,2,2},
                        ParameterType.COST, new int[]{4,1,1,1,1,1},
                        ParameterType.ANSWER, 2
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.GAS, new int[]{0,10},
                        ParameterType.COST,  new int[]{5,3},
                        ParameterType.ANSWER, 1
                )});
    }

    private int[] fInputGas;
    private int[] fInputCost;
    private int fExpected;

    public GasStationTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fInputGas = (int[]) parametersMap.get(ParameterType.GAS);
        fInputCost = (int[]) parametersMap.get(ParameterType.COST);
        fExpected = (int) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldCheckIfCanCompleteCircuit() {
        assertEquals(fExpected, new GasStation().canCompleteCircuit(fInputGas, fInputCost));
    }

}