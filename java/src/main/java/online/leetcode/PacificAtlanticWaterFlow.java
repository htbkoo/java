package online.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Hey on 05/Oct/2025
 */

/*
417. Pacific Atlantic Water Flow
https://leetcode.com/classic/problems/pacific-atlantic-water-flow/description/

There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.



Example 1:

Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.

Example 2:

Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.



Constraints:

    m == heights.length
    n == heights[r].length
    1 <= m, n <= 200
    0 <= heights[r][c] <= 105

*/

class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        var HEIGHT = heights.length;
        var WIDTH = heights[0].length;
        var pacific = new boolean[HEIGHT][WIDTH];
        Deque<List<Integer>> q = new ArrayDeque<>();
        for (var y = 0; y < HEIGHT; ++y) {
            q.add(List.of(y, 0));
        }
        for (var x = 1; x < WIDTH; ++x) {
            q.add(List.of(0, x));
        }
        populate(q, heights, pacific);

        var atlantic = new boolean[HEIGHT][WIDTH];
        q = new ArrayDeque<>();
        for (var y = 0; y < HEIGHT; ++y) {
            q.add(List.of(y, WIDTH - 1));
        }
        for (var x = 0; x < WIDTH - 1; ++x) {
            q.add(List.of(HEIGHT  - 1, x));
        }
        populate(q, heights, atlantic);

        List<List<Integer>> answer = new ArrayList<>();
        for (var y = 0; y < HEIGHT; ++y) {
            for (var x = 0; x < WIDTH; ++x) {
                if (pacific[y][x] && atlantic[y][x]) {
                    answer.add(List.of(y, x));
                }
            }
        }
        return answer;
    }

    private void populate(Deque<List<Integer>> q, int[][] heights, boolean[][] reach) {
        var HEIGHT = heights.length;
        var WIDTH = heights[0].length;
        var visited = new boolean[HEIGHT][WIDTH];
        while (!q.isEmpty()) {
            var coors = q.pollFirst();
            var y = coors.get(0);
            var x = coors.get(1);
            if (visited[y][x]){
                continue;
            }
            visited[y][x] = true;
            reach[y][x] = true;

            for (var next: List.of(List.of(y - 1, x), List.of(y, x - 1), List.of(y + 1, x), List.of(y, x + 1))) {
                int ny = next.get(0);
                int nx = next.get(1);
                boolean isWithinBoundary = 0 <= ny && ny < HEIGHT && 0 <= nx && nx < WIDTH;
                if (!isWithinBoundary) {
                    continue;
                }
                if (heights[ny][nx] < heights[y][x]) {
                    continue;
                }
                q.add(next);
            }
        }
    }
}
