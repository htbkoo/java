package online.codewars._6kyu;

import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 25 Jul 2016
 */
public class CartesianCoordinatesFromDegreeAngleTest {


    @Test
    public void test_1() {
        Point2D result = new CartesianCoordinatesFromDegreeAngle.CoordinatesInspector().coordinates(90.0,1.0);
        assertEquals("Incorrect coordinates", new Point2D.Double(0.0,1.0), result);
    }


}