package online.codewars._6kyu;

import online.codewars._6kyu.TortoiseRacing.Tortoise;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Hey on 27 Jul 2016
 */
public class TortoiseRacingTest {

    @Test
    public void test1() {
        System.out.println("Basic Tests");
        assertArrayEquals(new int[]{0, 32, 18}, Tortoise.race(720, 850, 70));
        assertArrayEquals(new int[]{3, 21, 49}, Tortoise.race(80, 91, 37));
        assertArrayEquals(new int[]{2, 0, 0}, Tortoise.race(80, 100, 40));
    }

}