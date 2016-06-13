package online.codewars._6kyu;

import org.junit.Test;

import static online.codewars._6kyu.RoutesInASquareGrid.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 13 Jun 2016
 */
public class RoutesInASquareGridTest {

    @Test
    public void simpleTests() {
        assertEquals(2, RoutesCalc.calculateRoutes(1));
        assertEquals(6, RoutesCalc.calculateRoutes(2));
        assertEquals(20, RoutesCalc.calculateRoutes(3));
        assertEquals(137846528820L, RoutesCalc.calculateRoutes(20));
        assertEquals("If there are no squares there can't be any routes", 0, RoutesCalc.calculateRoutes(-4));
    }

}