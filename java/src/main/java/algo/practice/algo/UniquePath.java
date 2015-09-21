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
        int find(int m, int n);
    }

    public static class UniquePathByRecursiveDP implements UniquePathStrategy {
        Simple2DArray<Integer> dpTable;

        @Override
        public int find(int m, int n) {
            dpTable = new Simple2DArray<>(Integer.class, m, n);
            return dp(m, n);
        }

        private int dp(int i, int j) {
//            if (i==1 || j==1)
//                return
            throw new UnsupportedOperationException("Not yet implemented");
//            return 0;
        }
    }

    public static class UniquePathByIterationDP implements UniquePathStrategy {
        Simple2DArray<Integer> dpTable;

        @Override
        public int find(int m, int n) {
            dpTable = new Simple2DArray<>(Integer.class, m, n);

            for (int i = 1; i <= m; i++) {
                dpTable.put(i, 1, 1);
            }
            for (int j = 1; j <= n; j++) {
                dpTable.put(1, j, 1);
            }

            for (int i = 2; i <= m; i++) {
                for (int j = 2; j <= n; j++) {
                    dpTable.put(i, j, dpTable.get(i - 1, j).get() + dpTable.get(i, j - 1).get());
                }
            }
            return dpTable.get(m, n).get();
        }

        private int dp(int i, int j) {


//            if (i==1 || j==1)
//                return
            throw new UnsupportedOperationException("Not yet implemented");
//            return 0;
        }
    }

    public static class UniquePathByNaiveDFS implements UniquePathStrategy {
        @Override
        public int find(int m, int n) {
            throw new UnsupportedOperationException("Not yet implemented");
//            return 0;
        }
    }

    public int getNumberOfUniquePaths(UniquePathStrategy strategy, int m, int n) {
        return strategy.find(m, n);
    }
}
