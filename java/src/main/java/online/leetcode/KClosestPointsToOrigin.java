package online.leetcode;

/*

https://leetcode.com/problems/k-closest-points-to-origin/

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)



Note:

    1 <= K <= points.length <= 10000
    -10000 < points[i][0] < 10000
    -10000 < points[i][1] < 10000

*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    static class Solution {
        static class Point {
            private final int[] point;

            Point(int[] point) {
                this.point = point;
            }

            static Point fromArray(int[] point) {
                return new Point(point);
            }

            int getX() {
                return point[0];
            }

            int getY() {
                return point[1];
            }

            int sqDistFromOrigin() {
                int x = getX(), y = getY();
                return x * x + y * y;
            }

            int[] asArray() {
                return point;
            }

            boolean isCloserToOriginThan(Point other) {
                return sqDistFromOrigin() < other.sqDistFromOrigin();
            }
        }

        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<Point> maxHeap = new PriorityQueue<>(Comparator.comparing(Point::sqDistFromOrigin).reversed());

            Arrays.stream(points)
                    .map(Point::fromArray)
                    .forEach(point -> {
                        // populate heap
                        if (maxHeap.size() < K) {
                            maxHeap.add(point);
                        } else {
                            if (maxHeap.isEmpty()) {
                                throw new IllegalStateException("heap is empty");
                            } else {
                                Point farthest = maxHeap.peek();

                                if (point.isCloserToOriginThan(farthest)) {
                                    maxHeap.poll();
                                    maxHeap.add(point);
                                }
                            }
                        }
                    });

            return maxHeap.stream()
                    .map(Point::asArray)
                    .toArray(int[][]::new);
        }
    }
}
