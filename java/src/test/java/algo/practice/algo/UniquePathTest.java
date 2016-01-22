package algo.practice.algo;

import common.test.utils.SimpleTestingTimer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

        SimpleTestingTimer.SimpleTestingTimerResult<Long> result = SimpleTestingTimer.<Long>time(uniquePath, "getNumberOfUniquePaths", new UniquePath.UniquePathByRecursiveDP(), 30, 30);
        long numberOfUniquePaths = result.getReturnValue();

        assertEquals(30067266499541040L, numberOfUniquePaths);
        logger.info("Time needed by RecursiveDP: " + result.getTimeNeeded());
    }

    @Test
    public void shouldFindUniquePathByIterationDP() throws Exception {
        assertEquals(2, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByIterationDP(), 2, 2));
        assertEquals(6, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByIterationDP(), 3, 3));
        assertEquals(70, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByIterationDP(), 5, 5));

        SimpleTestingTimer.SimpleTestingTimerResult<Long> result = SimpleTestingTimer.<Long>time(uniquePath, "getNumberOfUniquePaths", new UniquePath.UniquePathByIterationDP(), 30, 30);
        long numberOfUniquePaths = result.getReturnValue();

        assertEquals(30067266499541040L, numberOfUniquePaths);
        logger.info("Time needed by IterationDP: " + result.getTimeNeeded());
    }

    @Test
    public void shouldFindUniquePathByNaiveDFS() throws Exception {
        assertEquals(2, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByNaiveDFS(), 2, 2));
        assertEquals(6, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByNaiveDFS(), 3, 3));
        assertEquals(70, uniquePath.getNumberOfUniquePaths(new UniquePath.UniquePathByNaiveDFS(), 5, 5));

        SimpleTestingTimer.SimpleTestingTimerResult<Long> result = SimpleTestingTimer.<Long>time(uniquePath, "getNumberOfUniquePaths", new UniquePath.UniquePathByNaiveDFS(), 15, 15);

        long numberOfUniquePaths = result.getReturnValue();

        assertEquals(40116600, numberOfUniquePaths);
        logger.info("Time needed by NaiveDFS: " + result.getTimeNeeded());

    }
}