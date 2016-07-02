package online.leetcode;

import java.util.Arrays;

/**
 * Created by Hey on 1 Jul 16
 */

/*

https://leetcode.com/problems/maximum-gap/

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

Credits:
Special thanks to @porker2008 for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class MaximumGap {
    //    official answer, using bucket sort
//    http://blog.csdn.net/u012162613/article/details/41936569
    /* Suppose there are N elements and they range from A to B.

Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)]

Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)], then we will have at most num = (B - A) / len + 1 of bucket

for any number K in the array, we can easily find out which bucket it belongs by calculating loc = (K - A) / len and therefore maintain the maximum and minimum elements in each bucket.

Since the maximum difference between elements in the same buckets will be at most len - 1, so the final answer will not be taken from two elements in the same buckets.

For each non-empty buckets p, find the next non-empty buckets q, then q.min - p.max could be the potential answer to the question. Return the maximum of all those values.*/
    public int maximumGap(int[] nums) {
        final int length = nums.length;

        if (length < 2) {
            return 0;
        }

        int min = nums[0], max = nums[0];

        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        final int sizeOfBucket = (max - min) / length + 1;
        final int numOfBucket = (max - min) / sizeOfBucket + 1;
        final int[] bMins = new int[numOfBucket], bMaxs = new int[numOfBucket];
        Arrays.fill(bMins, Integer.MAX_VALUE);
        Arrays.fill(bMaxs, Integer.MIN_VALUE);

        for (int n : nums) {
            final int bucketIndex = (n - min) / sizeOfBucket;
            bMins[bucketIndex] = Math.min(bMins[bucketIndex], n);
            bMaxs[bucketIndex] = Math.max(bMaxs[bucketIndex], n);
        }

        int maxDiff = 0;
        int last = 0;
        for (int i = 1; i < numOfBucket; ++i) {
            if (bMaxs[i] > Integer.MIN_VALUE) {
                maxDiff = Math.max(maxDiff, bMins[i] - bMaxs[last]);
                last = i;
            }
        }

        return maxDiff;
    }

    private class FailedAttemptOfDisjointSet {
        //    Attempting Disjoint set approach
        public int maximumGap(int[] nums) {
            final int length = nums.length;
            return 0;
        }

        private class MaximumGapDisjointSet {
            private final int[] parent, rank;

            public MaximumGapDisjointSet(int size) {
                parent = new int[size];
                rank = new int[size];
            }

            public int find(int i) {
//            path compression
                if (parent[i] != i) {
                    parent[i] = find(parent[i]);
                }
                return parent[i];
            }

            //        union by rank
            void union(int x, int y) {
                int x_root = find(x);
                int y_root = find(y);
                if (x_root != y_root) {
                    if (rank[x_root] < rank[y_root])
                        parent[x_root] = y_root;
                    else if (rank[x_root] > rank[y_root])
                        parent[y_root] = x_root;
                    else {
                        parent[y_root] = x_root;
                        rank[x_root]++;
                    }
                }
            }

        }

    }
}

