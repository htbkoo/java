package online.leetcode;

/**
 * Created by Hey on 5/4/16
 */
/*

https://leetcode.com/problems/range-sum-query-immutable/

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:

    You may assume that the array does not change.
    There are many calls to sumRange function.

Subscribe to see which companies asked this question

*/

public class RangeSumQueryImmutable {
    public class NumArray {
        private final int[][] sums;
        private final int length;
        private final int width;
        private final int height;

        public NumArray(int[] nums) {
            length = nums.length;
            width = length;
            height = (int) (Math.log(length) / Math.log(2)) + 1;

            sums = new int[height][];
            buildSparseTable(nums);
        }

        public int sumRange(int i, int j) {
            if (i == j) {
                return sums[0][i];
            }

            final int diff = j - i;
            final int row = (int) (Math.log(diff + 1) / Math.log(2));
            final int afterRangeIndex = i + (int) Math.pow(2, row);
            return sums[row][i] + ((afterRangeIndex > j) ? 0 : sumRange(afterRangeIndex, j));
        }

        private void buildSparseTable(int[] nums) {
            copyFirstRow(nums);
            for (int i = 1; i < height; ++i) {
                sums[i] = new int[width];
                for (int j = 0; j < width; j++) {
                    final int nextIndex = j + (int) Math.pow(2, i - 1);
                    final int upperLeftValue = sums[i - 1][j];
                    final int upperRightValue = (nextIndex >= width) ? 0 : sums[i - 1][nextIndex];
                    sums[i][j] = upperLeftValue + upperRightValue;
                }
            }
        }

        private void copyFirstRow(int[] nums) {
            sums[0] = new int[width];
            System.arraycopy(nums, 0, sums[0], 0, width);
        }
    }

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

    public class FailedAttemptNumArray {
        final int[][] sums;
        final int length;
        final int width;
        final int height;

        public FailedAttemptNumArray(int[] nums) {
            length = nums.length;
            width = length;
            height = (int) (Math.log(length) / Math.log(2)) + 1;

            sums = new int[height][];
            buildSparseTable(nums);
        }

        public int sumRange(int i, int j) {
            final int diff = j - i;
            final int maxDiff = (i == 0) ? diff : (maxFactor(i) - 1);

//            (int) (Math.log(i) / Math.log(2));

//            if (i != 1 && isPowerOfTwo(i)) {
//                diff
//            } ;
//            j != 1 && isPowerOfTwo(j);
            return 0;
        }

        private int maxFactor(int i) {
            int factor = 1;
            while ((2 * factor) < i) {
                if (i % (2 * factor) != 0) {
                    return factor;
                }
                factor *= 2;
            }
            return factor;
        }

        private boolean isPowerOfTwo(int n) {
            return (n > 0) && ((n & (n - 1)) == 0);
        }

        private void buildSparseTable(int[] nums) {
            copyFirstRow(nums);
            for (int i = 1; i < height; ++i) {
                sums[i] = new int[width];
                for (int j = 0; j < width; j += (int) Math.pow(2, i)) {
                    sums[i][j] = sums[i - 1][j] + sums[i - 1][j + (int) Math.pow(2, i - 1)];
                }
            }
        }

        private void copyFirstRow(int[] nums) {
            sums[0] = new int[width];
            System.arraycopy(nums, 0, sums[0], 0, width);
        }
    }

}
