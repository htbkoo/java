package algo.practice.algo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 21/9/15
 */
public class UniquePathTest {
    UniquePath uniquePath;
    private static Logger logger = LogManager.getLogger(UniquePathTest.class);

    @Before
    public void setUp() throws Exception {
        uniquePath = new UniquePath();
    }

    @Test
    public void shouldFindUniquePathByRecursiveDP() throws Exception {
        assertEquals(2, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByRecursiveDP(), 2, 2));
        assertEquals(6, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByRecursiveDP(), 3, 3));
        assertEquals(70, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByRecursiveDP(), 5, 5));
        Instant before = new DateTime().toInstant();
        int numberOfUniquePaths = uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByRecursiveDP(), 17, 17);
        Instant after = new DateTime().toInstant();

        assertEquals(601080390, numberOfUniquePaths);
        logger.info("Time needed by RecursiveDP: " + (after.getMillis() - before.getMillis()));
    }

    @Test
    public void shouldFindUniquePathByIterationDP() throws Exception {
        assertEquals(2, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByIterationDP(), 2, 2));
        assertEquals(6, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByIterationDP(), 3, 3));
        assertEquals(70, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByIterationDP(), 5, 5));

        Instant before = new DateTime().toInstant();
        int numberOfUniquePaths = uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByIterationDP(), 17, 17);
        Instant after = new DateTime().toInstant();

        assertEquals(601080390, numberOfUniquePaths);
        logger.info("Time needed by IterationDP: " + (after.getMillis() - before.getMillis()));
    }

    @Test
    public void shouldFindUniquePathByNaiveDFS() throws Exception {
        assertEquals(2, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByNaiveDFS(), 2, 2));
        assertEquals(6, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByNaiveDFS(), 3, 3));
        assertEquals(70, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByNaiveDFS(), 5, 5));

        Instant before = new DateTime().toInstant();
        int numberOfUniquePaths = uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByNaiveDFS(), 17, 17);
        Instant after = new DateTime().toInstant();

        assertEquals(601080390, numberOfUniquePaths);
        logger.info("Time needed by DFS: " + (after.getMillis() - before.getMillis()));
    }
}