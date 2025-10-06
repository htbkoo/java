package online.leetcode;

/**
 * Created by Hey on 06/Oct/2025
 */

/*
778. Swim in Rising Water
https://leetcode.com/classic/problems/swim-in-rising-water/description/

You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

It starts raining, and water gradually rises over time. At time t, the water level is t, meaning any cell with elevation less than equal to t is submerged or reachable.

You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the minimum time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).



Example 1:

Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.

Example 2:

Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation: The final route is shown.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.



Constraints:

    n == grid.length
    n == grid[i].length
    1 <= n <= 50
    0 <= grid[i][j] < n2
    Each value grid[i][j] is unique.

*/

class FirstSwimInRisingWater {
    private static final int START_Y = 0;
    private static final int START_X = 0;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int swimInWater(int[][] grid) {
        // TODO: validate grid is valid
        final int HEIGHT = grid.length;
        final int WIDTH = grid[0].length;

        int lo = 0;
        int hi = HEIGHT * WIDTH;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            var visited = new boolean[HEIGHT][WIDTH];
            if (canReach(grid, visited, mid, START_Y, START_X)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private boolean canReach(int[][] grid, boolean[][] visited, int t, int y, int x) {
        final int HEIGHT = grid.length;
        final int WIDTH = grid[0].length;
        final int targetY = HEIGHT - 1;
        final int targetX = WIDTH - 1;

        boolean isWithinBoundary = 0 <= y && y < HEIGHT && 0 <= x && x < WIDTH;
        if (!isWithinBoundary) {
            return false;
        }
        if (grid[y][x] > t) {
            return false;
        }

        if (y == targetY && x == targetX) {
            return true;
        }

        if (visited[y][x]) {
            return false;
        }
        visited[y][x] = true;
        for (var dir : DIRECTIONS) {
            var ny = y + dir[0];
            var nx = x + dir[1];
            if (canReach(grid, visited, t, ny, nx)) {
                return true;
            }
        }
        return false;
    }
}
