package algo.practice.algo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 21/9/15
 */
public class UniquePathTest {
    UniquePath uniquePath;

    @Before
    public void setUp() throws Exception {
        uniquePath = new UniquePath();
    }

    @Test
    public void shouldFindUniquePathByRecursiveDP() throws Exception {
        assertEquals(2, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByRecursiveDP(), 2, 2));
        assertEquals(6, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByRecursiveDP(), 3, 3));
        assertEquals(70, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByRecursiveDP(), 5, 5));

    }

    @Test
    public void shouldFindUniquePathByIterationDP() throws Exception {
        assertEquals(2, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByIterationDP(), 2, 2));
        assertEquals(6, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByIterationDP(), 3, 3));
        assertEquals(70, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByIterationDP(), 5, 5));
        assertEquals(51542064, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByIterationDP(), 30, 30));
    }

    @Test
    public void shouldFindUniquePathByNaiveDFS() throws Exception {
        assertEquals(2, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByNaiveDFS(), 2, 2));
        assertEquals(6, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByNaiveDFS(), 3, 3));

    }
}