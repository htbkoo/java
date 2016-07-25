package online.codewars._6kyu;

import java.awt.geom.Point2D;
import java.text.DecimalFormat;

/**
 * Created by Hey on 25 Jul 2016.
 * <p>
 * ---
 * <p>
 * https://www.codewars.com/kata/cartesian-coordinates-from-degree-angle/train/java
 */

/*

Write a simple function that takes polar coordinates (an angle in degrees and a radius) and returns the equivalent cartesian coordinates (rouded to 10 places).

For example:

coordinates(90,1)
=> (0.0, 1.0)

coordinates(45, 1)
=> (0.7071067812, 0.7071067812)

* */

@SuppressWarnings("WeakerAccess")
public class CartesianCoordinatesFromDegreeAngle {
    public static class CoordinatesInspector {

        public Point2D coordinates(Double degrees, Double radius) {
            Double radian = degrees / 180.0 * Math.PI;
            double x = radius * Math.cos(radian);
            double y = radius * Math.sin(radian);
            DecimalFormat df = new DecimalFormat("#.##########");
            return new Point2D.Double(Double.parseDouble(df.format(x)),Double.parseDouble(df.format(y)));
        }

    }
}