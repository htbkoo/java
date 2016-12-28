package online.codewars._8kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 29 Dec 2016
 */
public class VolumeOfACuboidTest {

    private static final double delta = 0.0001;

    @Test
    public void examples() {
        // assertEquals("expected", "actual");
        assertEquals(4, VolumeOfACuboid.Kata.getVolumeOfCuboid(1, 2, 2), delta);
        assertEquals(63, VolumeOfACuboid.Kata.getVolumeOfCuboid(6.3, 2, 5), delta);
    }
}