package online.codewars._6kyu;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static online.codewars._6kyu.BouncingBalls.BouncingBall;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Hey on 24 Jul 2016
 */
@RunWith(Parameterized.class)
public class BouncingBallsTest {

    private final double h;
    private final double bounce;
    private final double window;
    private final int fExpected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{24.000000, 0.390000, 2.400000, 5},
                new Object[]{3.000000, 0.660000, 1.500000, 3},
                new Object[]{30.000000, 0.660000, 1.500000, 15},
                new Object[]{30.000000, 0.750000, 1.500000, 21},
                new Object[]{30.000000, 0.400000, 10.000000, 3},
                new Object[]{40.000000, 0.400000, 10.000000, 3},
                new Object[]{10.000000, 0.600000, 10.000000, -1},
                new Object[]{40.000000, 1.000000, 10.000000, -1},
                new Object[]{-5.000000, 0.660000, 1.500000, -1},
                new Object[]{5.000000, -1.000000, 1.500000, -1},
                new Object[]{3.0, 0.66, 1.5, 3},
                new Object[]{30.0, 0.66, 1.5, 15}
        );
    }


    public BouncingBallsTest(double h, double bounce, double window, int fExpected) {
        this.h = h;
        this.bounce = bounce;
        this.window = window;
        this.fExpected = fExpected;
    }

    @Test
    public void shouldCountBouncingBall() throws Exception {
        assertThat(BouncingBall.bouncingBall(h, bounce, window), is(fExpected));
    }

    @Ignore
    @Test
    public void test1() {
        assertEquals(3, BouncingBall.bouncingBall(3.0, 0.66, 1.5));
    }

    @Ignore
    @Test
    public void test2() {
        assertEquals(15, BouncingBall.bouncingBall(30.0, 0.66, 1.5));
    }

}





    