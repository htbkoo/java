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
public class CoinChangeTest {
    private enum ParameterType {
        COINS, AMOUNT, ANSWER
    }

    @Parameterized.Parameters
    public static Collection<Map<ParameterType, Object>[]> data() {
        //noinspection unchecked
        return Arrays.<Map<ParameterType, Object>[]>asList(
                new Map[]{ImmutableMap.of(
                        ParameterType.COINS, new int[]{},
                        ParameterType.AMOUNT, 0,
                        ParameterType.ANSWER, 0
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.COINS, new int[]{2},
                        ParameterType.AMOUNT, 1,
                        ParameterType.ANSWER, -1
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.COINS, new int[]{1, 2, 5},
                        ParameterType.AMOUNT, 11,
                        ParameterType.ANSWER, 3
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.COINS, new int[]{1, 7, 10},
                        ParameterType.AMOUNT, 14,
                        ParameterType.ANSWER, 2
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.COINS, new int[]{7, 10},
                        ParameterType.AMOUNT, 14,
                        ParameterType.ANSWER, 2
                )},
                new Map[]{ImmutableMap.of(
                        ParameterType.COINS, new int[]{1, 7, 10},
                        ParameterType.AMOUNT, 56,
                        ParameterType.ANSWER, 8
//                )},
//                new Map[]{ImmutableMap.of(
//                        ParameterType.COINS, new int[]{1},
//                        ParameterType.AMOUNT, 2147483647,
//                        ParameterType.ANSWER, 8
                )});
    }

    private int[] fCoins;
    private int fAmount;
    private int fExpected;

    public CoinChangeTest(Map<ParameterType, Object> parametersMap) {
//        This method may be nasty and it should be improved
        fCoins = (int[]) parametersMap.get(ParameterType.COINS);
        fAmount = (int) parametersMap.get(ParameterType.AMOUNT);
        fExpected = (int) parametersMap.get(ParameterType.ANSWER);
    }

    @Test
    public void shouldGetMinimumAmountOfCoinsNeeded() {
        assertEquals(fExpected, new CoinChange().coinChange(fCoins, fAmount));
    }

}