package algo.practice.algo;

import algo.practice.utils.Simple2DArray;

/**
 * Created by Hey on 21/9/15
 * <p>
 * -----------------------------
 * <p>
 * A robot is located at the top-left corner of a m x n grid. It can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid.
 * How many possible unique paths are there?
 * <p>
 * http://www.programcreek.com/2014/05/leetcode-unique-paths-java/
 */
//assume start at (1,1)
public class UniquePath {

    private interface UniquePathStrategy {
        long find(int m, int n);
    }

    public static class UniquePathByRecursiveDP implements UniquePathStrategy {
        Simple2DArray<Long> dpTable;

        @Override
        public long find(int m, int n) {
            dpTable = new Simple2DArray<>(m, n);
            return dp(m, n);
        }

        private long dp(int i, int j) {
            if (i == 1 || j == 1) {
                if (!dpTable.get(i, j).isPresent()) {
                    dpTable.put(i, j, 1L);
                }
                return dpTable.get(i, j).get();
            } else {
                if (!dpTable.get(i - 1, j).isPresent()) {
                    dpTable.put(i - 1, j, dp(i - 1, j));
                }
                if (!dpTable.get(i, j - 1).isPresent()) {
                    dpTable.put(i, j - 1, dp(i, j - 1));
                }
                return dpTable.get(i - 1, j).get() + dpTable.get(i, j - 1).get();
            }
        }
    }

    public static class UniquePathByIterationDP implements UniquePathStrategy {
        Simple2DArray<Long> dpTable;

        @Override
        public long find(int m, int n) {
            dpTable = new Simple2DArray<>(m, n);

            for (int i = 1; i <= m; i++) {
                dpTable.put(i, 1, 1L);
            }
            for (int j = 1; j <= n; j++) {
                dpTable.put(1, j, 1L);
            }

            for (int i = 2; i <= m; i++) {
                for (int j = 2; j <= n; j++) {
                    dpTable.put(i, j, dpTable.get(i - 1, j).get() + dpTable.get(i, j - 1).get());
                }
            }
            return dpTable.get(m, n).get();
        }

    }

    public static class UniquePathByNaiveDFS implements UniquePathStrategy {
        @Override
        public long find(int m, int n) {
            return dfs(0,0,m,n);
        }

        public long dfs(int i, int j, int m, int n){
            if(i==m-1 && j==n-1){
                return 1;
            }

            if(i<m-1 && j<n-1){
                return dfs(i+1,j,m,n) + dfs(i,j+1,m,n);
            }

            if(i<m-1){
                return dfs(i+1,j,m,n);
            }

            if(j<n-1){
                return dfs(i,j+1,m,n);
            }

            return 0;
        }
    }

    public long getNumberOfUniquePaths(UniquePathStrategy strategy, int m, int n) {
        return strategy.find(m, n);
    }
}
