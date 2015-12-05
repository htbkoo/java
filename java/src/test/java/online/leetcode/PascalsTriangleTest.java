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
public class PascalsTriangleTest {
    @Parameters
    public static Collection<Pair<Integer, List<List<Integer>>>[]> data() {
        //noinspection unchecked
        return Arrays.<Pair<Integer, List<List<Integer>>>[]>asList(
                new Pair[]{
                        new ImmutablePair<>
                                (0, Collections.EMPTY_LIST)
                }, new Pair[]{
                        new ImmutablePair<>
                                (1, Collections.singletonList(
                                        Collections.singletonList(1)
                                ))
                }, new Pair[]{
                        new ImmutablePair<>
                                (2, Arrays.asList(
                                        Collections.singletonList(1),
                                        Arrays.asList(1, 1)
                                ))
                }, new Pair[]{
                        new ImmutablePair<>
                                (3, Arrays.asList(
                                        Collections.singletonList(1),
                                        Arrays.asList(1, 1),
                                        Arrays.asList(1, 2, 1)
                                ))
                }, new Pair[]{
                        new ImmutablePair<>
                                (4, Arrays.asList(
                                        Collections.singletonList(1),
                                        Arrays.asList(1, 1),
                                        Arrays.asList(1, 2, 1),
                                        Arrays.asList(1, 3, 3, 1)
                                ))
                }, new Pair[]{
                        new ImmutablePair<>
                                (5, Arrays.asList(
                                        Collections.singletonList(1),
                                        Arrays.asList(1, 1),
                                        Arrays.asList(1, 2, 1),
                                        Arrays.asList(1, 3, 3, 1),
                                        Arrays.asList(1, 4, 6, 4, 1)
                                ))
                }, new Pair[]{
                        new ImmutablePair<>
                                (7, Arrays.asList(
                                        Collections.singletonList(1),
                                        Arrays.asList(1, 1),
                                        Arrays.asList(1, 2, 1),
                                        Arrays.asList(1, 3, 3, 1),
                                        Arrays.asList(1, 4, 6, 4, 1),
                                        Arrays.asList(1, 5, 10, 10, 5, 1),
                                        Arrays.asList(1, 6, 15, 20, 15, 6, 1)
                                ))
                });
    }

    private int fInput;
    private List<List<Integer>> fExpected;

    public PascalsTriangleTest(Pair<Integer, List<List<Integer>>> inputExpectedPair) {
        fInput = inputExpectedPair.getLeft();
        fExpected = inputExpectedPair.getRight();
    }

    @Test
    public void shouldGeneratePascalsTriangle() {
        assertEquals(fExpected, new PascalsTriangle().generate(fInput));
    }
}