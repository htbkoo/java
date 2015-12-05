package online.leetcode;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 5/12/15
 */
@RunWith(Parameterized.class)
public class PascalsTriangleIITest {
    @Parameters
    public static Collection<Pair<Integer, List<Integer>>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, List<Integer>>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (0, Collections.singletonList(1))
                }, new Pair[]{
                        new ImmutablePair<>
                                (1, Arrays.asList(1, 1))
                }, new Pair[]{
                        new ImmutablePair<>
                                (2, Arrays.asList(1, 2, 1))
                }, new Pair[]{
                        new ImmutablePair<>
                                (3, Arrays.asList(1, 3, 3, 1))
                }, new Pair[]{
                        new ImmutablePair<>
                                (4, Arrays.asList(1, 4, 6, 4, 1))
                }, new Pair[]{
                        new ImmutablePair<>
                                (6, Arrays.asList(1, 6, 15, 20, 15, 6, 1))
                }, new Pair[]{
                        new ImmutablePair<>
                                (10, Arrays.asList(1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1))
                }, new Pair[]{
                        new ImmutablePair<>
                                (30, Arrays.asList(1, 30, 435, 4060, 27405, 142506, 593775, 2035800, 5852925, 14307150, 30045015, 54627300, 86493225, 119759850, 145422675, 155117520, 145422675, 119759850, 86493225, 54627300, 30045015, 14307150, 5852925, 2035800, 593775, 142506, 27405, 4060, 435, 30, 1))
                });
    }

    private int fInput;
    private List<Integer> fExpected;

    public PascalsTriangleIITest(Pair<Integer, List<Integer>> inputExpectedPair) {
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldGeneratePascalsTriangle() {
        assertEquals(fExpected, new PascalsTriangleII().getRow(fInput));
    }
}