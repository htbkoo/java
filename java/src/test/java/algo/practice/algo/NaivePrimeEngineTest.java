package algo.practice.algo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 20/9/15
 */
public class NaivePrimeEngineTest {
    private static Logger logger = LogManager.getLogger(NaivePrimeEngineTest.class);

    NaivePrimeEngine naivePrimeEngine;

    @Before
    public void setUp() throws Exception {
        naivePrimeEngine = new NaivePrimeEngine();
    }

    @Test
    public void shouldListAllPrimeNumbersLessThanTen() throws Exception {
        assertEquals(Arrays.asList(2, 3, 5, 7),
                naivePrimeEngine.listPrimeBetween(2, 10));
    }

    @Test
    public void shouldGetTwentyFivePrimeNumbersLessThanHundred() throws Exception {
        assertEquals(25,
                naivePrimeEngine.listPrimeBetween(2, 100).size());
    }

    @Test
    public void profilingForListAllPrimeNumbersLessThanFiveHundreds() throws Exception {
        Instant before = new DateTime().toInstant();
        List<Integer> primes = naivePrimeEngine.listPrimeBetween(2, 500);
        Instant after = new DateTime().toInstant();

        logger.info(primes);
        assertEquals("Size is not 95!", 95, primes.size());
        logger.info("Number of steps: " + naivePrimeEngine.getSteps());
        logger.info("Time needed: " + (after.getMillis() - before.getMillis()));
    }

    @Test
    public void profilingForListAllPrimeNumbersLessThanHundredThousands() throws Exception {
        Instant before = new DateTime().toInstant();
        List<Integer> primes = naivePrimeEngine.listPrimeBetween(2, 100000);
        Instant after = new DateTime().toInstant();

        logger.info(primes);
        assertEquals("Size is not 9592!", 9592, primes.size());
        logger.info("Number of steps: " + naivePrimeEngine.getSteps());
        logger.info("Time needed: " + (after.getMillis() - before.getMillis()));
    }

}