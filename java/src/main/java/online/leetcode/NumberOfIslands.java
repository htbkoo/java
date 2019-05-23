package online.leetcode;

/*

https://leetcode.com/problems/number-of-islands/

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3

*/

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslands {
    static class Solution {
        private class Coordinate{
            final int x;
            final int y;

            Coordinate(int x,int y){
                this.x=x;
                this.y=y;
            }
        }

        public int numIslands(char[][] grid) {
            if (grid==null || grid.length==0){
                return 0;
            }else{
                int height = grid.length;
                int width = grid[0].length;
                if (width == 0){
                    return 0;
                }else{
                    int numIsland = 0;
                    boolean[][] visited = new boolean[height][width];
                    for (int i=0;i<height;++i){
                        for (int j=0;j<width;++j){
                            if (!visited[i][j] && isLand(grid[i][j])){
                                numIsland++;
                                bfs(i, j, grid, visited);
                            }
                        }
                    }
                    return numIsland;
                }
            }
        }

        private boolean isLand(char c){
            return '1'==c;
        }

        private void bfs(int i, int j, char[][] grid, boolean[][] visited){
            Deque<Coordinate> queue = new ArrayDeque<>();
            queue.add(new Coordinate(i,j));
            while (!queue.isEmpty()){
                Coordinate coor = queue.poll();
                int x = coor.x;
                int y = coor.y;

                addQueueIfValid(x-1, y, grid, visited, queue);
                addQueueIfValid(x, y-1, grid, visited, queue);
                addQueueIfValid(x+1, y, grid, visited, queue);
                addQueueIfValid(x, y+1, grid, visited, queue);

                visited[x][y] =true;
            }
        }

        private void addQueueIfValid(int x, int y, char[][] grid, boolean[][] visited, Deque<Coordinate> queue){
            if (isWithinRange(x,y, grid) && !visited[x][y] && isLand(grid[x][y])){
                queue.add(new Coordinate(x,y));
            }
        }

        private boolean isWithinRange(int x, int y, char[][] grid){
            return (x>=0) && (y>=0) && (x<grid.length) && (y<grid[0].length);
        }
    }
}
