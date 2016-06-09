package online.codewars._5kyu;

import online.codewars._5kyu.PrimeFactorization.PrimeFactorizer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 7 Jun 2016
 */

@RunWith(Parameterized.class)
public class PrimeFactorizationTest {
    private static PrimeFactorizer worker;

    private final long n;
    private final Map<Long, Integer> factors;

    public PrimeFactorizationTest(long n, Map<Long, Integer> factors) {
        this.n = n;
        this.factors = factors;
    }

    @Parameterized.Parameters
    public static Collection<?> tests() {
        return Arrays.asList(new Object[][]{
                {13L, asMap(13, 1)}
                , {24L, asMap(2, 3, 3, 1)}
                , {343L, asMap(7, 3)}
                , {343L, asMap(7, 3)}
//                , {	982_451_653L, asMap(982_451_653L, 1)}
        });
    }

    private static Map<Long, Integer> asMap(long... data) {
        Map<Long, Integer> result = new HashMap<>(data.length >> 1);
        for (int i = 0; i < data.length; ++i)
            result.put(data[i], (int) data[++i]);
        return result;
    }

    @BeforeClass
    public static void init() {
        worker = new PrimeFactorizer();
    }

    @Test
    public void test() {
        assertEquals(factors, worker.factor(n));
    }
}