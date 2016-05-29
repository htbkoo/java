package online.codewars._4kyu;

import org.junit.Test;

import static online.codewars._4kyu.CatchingCarMileageNumbers.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 28 May 2016
 */
public class CatchingCarMileageNumbersTest {

    @Test
    public void testTooSmall() {
        assertEquals(0, CarMileage.isInteresting(3, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostAwesome() {
        assertEquals(1, CarMileage.isInteresting(1336, new int[]{1337, 256}));
    }

    @Test
    public void testAwesome() {
        assertEquals(2, CarMileage.isInteresting(1337, new int[]{1337, 256}));
    }

    @Test
    public void testFarNotInteresting() {
        assertEquals(0, CarMileage.isInteresting(11208, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostInteresting() {
        assertEquals(1, CarMileage.isInteresting(11209, new int[]{1337, 256}));
    }

    @Test
    public void testInteresting() {
        assertEquals(2, CarMileage.isInteresting(11211, new int[]{1337, 256}));
    }

    @Test
    public void testIncrementing() {
        assertEquals(2, CarMileage.isInteresting(234, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(123, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(1234, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(12345, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(123456, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(1234567, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(12345678, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(123456789, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(1234567890, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(234567890, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(34567890, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(4567890, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(567890, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(67890, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(7890, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(890, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(3456, new int[]{}));
    }

    @Test
    public void testUpcomingIncrementing() {
        assertEquals(1, CarMileage.isInteresting(1233, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(1232, new int[]{}));
    }

    @Test
    public void testDecrementing() {
        assertEquals(2, CarMileage.isInteresting(876, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(8765, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(87654, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(876543, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(8765432, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(87654321, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(876543210, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(76543210, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(6543210, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(543210, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(43210, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(3210, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(210, new int[]{}));
    }

    @Test
    public void testUpcomingDecrementing() {
        assertEquals(1, CarMileage.isInteresting(320, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(319, new int[]{}));
    }
}