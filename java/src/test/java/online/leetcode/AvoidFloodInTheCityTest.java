package online.leetcode;

import online.leetcode.infrastructure.LeetCodeUnitTest;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class AvoidFloodInTheCityTest extends LeetCodeUnitTest<int[], int[]> {

    public AvoidFloodInTheCityTest(int[] input, int[] expected) {
        super(input, expected);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new int[]{1, 2, 3, 4},
                        new int[]{-1, -1, -1, -1},
                },
                {
                        new int[]{1, 2, 0, 0, 2, 1},
                        new int[]{-1, -1, 2, 1, -1, -1},
                },
                {
                        new int[]{1, 2, 0, 1, 2},
                        new int[]{},
                },
                {
                        new int[]{1, 1, 0},
                        new int[]{},
                },
                {
                        new int[]{1, 0, 1},
                        new int[]{-1, 1, -1},
                },
                {
                        new int[]{1, 0, 2, 0, 2, 1},
                        new int[]{-1, 1, -1, 2, -1, -1},
                },
                {
                        new int[]{0, 1, 1},
                        new int[]{},
                },
                {
                        new int[]{1, 0, 2, 3, 0, 1, 2},
                        new int[]{-1, 1, -1, -1, 2, -1, -1},
                },
        });
    }

    @Override
    protected int[] getActual() {
        return new AvoidFloodInTheCity().avoidFlood(getInput());
    }
}
