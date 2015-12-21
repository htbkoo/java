package online.leetcode;

/**
 * Created by Hey on 7/12/15
 */

/*

https://leetcode.com/problems/rectangle-area/

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
Rectangle Area

Assume that the total area is never beyond the maximum possible value of int.

Credits:
Special thanks to @mithmatt for adding this problem, creating the above image and all test cases.

Subscribe to see which companies asked this question

*/

public class RectangleArea {
    private class Rectangle {
        final Point bL, tR;

        private Rectangle(Point point1, Point point2) {
            //        Note that "Each rectangle is defined by its bottom left corner and top right corner ", assume they may be swapped?
            if (point1.x <= point2.x) {
                this.bL = point1;
                this.tR = point2;
            } else {
                this.bL = point2;
                this.tR = point1;
            }
        }

    }

    private class Point {
        final int x, y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
//        final Rectangle rectangle1 = new Rectangle(new Point(A, B), new Point(C, D));
//        final Rectangle rectangle2 = new Rectangle(new Point(E, F), new Point(G, H));
//        int xOverlap = getOverlap(rectangle1.bL.x, rectangle1.tR.x, rectangle2.bL.x, rectangle2.tR.x);
//        int yOverlap = getOverlap(rectangle1.bL.y, rectangle1.tR.y, rectangle2.bL.y, rectangle2.tR.y);
        int rect1Area = (C - A) * (D - B);
        int rect2Area = (G - E) * (H - F);
        int xOverlap = getOverlap(A, C, E, G);
        int yOverlap = getOverlap(B, D, F, H);
        return rect1Area + rect2Area - xOverlap * yOverlap;
    }

    private int getOverlap(int os, int ob, int ts, int tb) {
        if (os > ts) {
            if (os >= tb) {
                return 0;
            } else {
                if (ob <= tb) {
                    return ob - os;
                } else {
                    return tb - os;
                }
            }
        } else if (ts > os) {
            if (ts >= ob) {
                return 0;
            } else {
                if (tb <= ob) {
                    return tb - ts;
                } else {
                    return ob - ts;
                }
            }
        } else {
            return Math.max(Math.min(ob, tb) - os, 0);
        }
    }
}
