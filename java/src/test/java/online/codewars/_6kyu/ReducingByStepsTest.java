package online.codewars._6kyu;

import online.codewars._6kyu.ReducingBySteps.Operarray;
import org.junit.Test;

import java.util.Arrays;

import static online.codewars._6kyu.ReducingBySteps.Operarray.operArray;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 18 Jun 2016
 */
public class ReducingByStepsTest {

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test0() {
        long[] a = new long[]{18, 69, -90, -78, 65, 40};

        long[] r = new long[]{18, 3, 3, 3, 1, 1};
        testing(Arrays.toString(operArray(Operarray::gcdi, a, a[0])),
                Arrays.toString(r));
        r = new long[]{18, 414, 2070, 26910, 26910, 107640};
        testing(Arrays.toString(operArray(Operarray::lcmu, a, a[0])),
                Arrays.toString(r));
        r = new long[]{18, 87, -3, -81, -16, 24};
        testing(Arrays.toString(operArray(Operarray::som, a, 0)),
                Arrays.toString(r));
        r = new long[]{18, 18, -90, -90, -90, -90};
        testing(Arrays.toString(operArray(Operarray::mini, a, a[0])),
                Arrays.toString(r));
        r = new long[]{18, 69, 69, 69, 69, 69};
        testing(Arrays.toString(operArray(Operarray::maxi, a, a[0])),
                Arrays.toString(r));
    }
}