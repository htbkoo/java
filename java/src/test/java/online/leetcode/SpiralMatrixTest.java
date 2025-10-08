package online.leetcode;

import online.leetcode.infrastructure.LeetCodeUnitTest;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SpiralMatrixTest extends LeetCodeUnitTest<int[][], List<Integer>> {

    public SpiralMatrixTest(int[][] input, List<Integer> expected) {
        super(input, expected);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5),
                },
                {
                        new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
                        Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
                },
                {
                        new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}},
                        Arrays.asList(1, 2, 4, 6, 8, 10, 9, 7, 5, 3),
                },
                {
                        new int[][]{{1, 2, 3, 4, 5, 6}},
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                },
                {
                        new int[][]{{1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 6}},
                        Arrays.asList(1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1),
                },
                {
                        new int[][]{{1}, {2}, {3}, {4}},
                        Arrays.asList(1, 2, 3, 4),
                },
                {
                        new int[][]{{1}},
                        List.of(1),
                },
        });
    }

    @Override
    protected List<Integer> getActual() {
        return new SpiralMatrix().spiralOrder(getInput());
    }
}
