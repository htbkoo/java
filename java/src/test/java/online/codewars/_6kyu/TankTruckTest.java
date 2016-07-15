package online.codewars._6kyu;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static online.codewars._6kyu.TankTruck.VolTank;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 14 Jul 2016
 */
@RunWith(Parameterized.class)
public class TankTruckTest {

    private final int h;
    private final int d;
    private final int vt;
    private final int fExpected;

    @Parameterized.Parameters(name = "[{0}] VolTank.tankVol({1},{2},{3}) = {4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{"1st fixed test", 5, 7, 3848, 2940},
                new Object[]{"2nd fixed test", 2, 7, 3848, 907},
                new Object[]{"1st example", 40, 120, 3500, 1021},
                new Object[]{"2nd example", 60, 120, 3500, 1750},
                new Object[]{"3rd example", 80, 120, 3500, 2478}
        );
    }

    public TankTruckTest(@SuppressWarnings("UnusedParameters") String name, int h, int d, int vt, int fExpected) {
        this.h = h;
        this.d = d;
        this.vt = vt;
        this.fExpected = fExpected;
    }

    @Test
    public void shouldCalTankVol() throws Exception {
        assertEquals(fExpected, VolTank.tankVol(h, d, vt));
    }

    @Ignore
    @Test
    public void test0() {
        System.out.println("Fixed Tests");
        assertEquals(2940, VolTank.tankVol(5, 7, 3848));
        assertEquals(907, VolTank.tankVol(2, 7, 3848));
    }
}