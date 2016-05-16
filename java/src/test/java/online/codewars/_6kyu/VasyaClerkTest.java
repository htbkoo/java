package online.codewars._6kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 16 May 2016
 */
public class VasyaClerkTest {
    @Test
    public void test1() {
        assertEquals("YES", VasyaClerk.Tickets(new int[] {25, 25, 50}));
    }
    @Test
    public void test2() {
        assertEquals("NO", VasyaClerk.Tickets(new int []{25, 100}));
    }
    @Test
    public void shouldReturnYesFor25_25_50_100() {
        assertEquals("YES", VasyaClerk.Tickets(new int []{25, 25, 50, 100}));
    }
}