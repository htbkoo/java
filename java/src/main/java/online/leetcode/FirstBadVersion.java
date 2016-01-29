package online.leetcode;

/**
 * Created by Hey on 29/1/16
 */

/*

https://leetcode.com/problems/first-bad-version/

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public abstract class FirstBadVersion {
    public int firstBadVersion(int n) {
        int high = n;
        int low = 1;

        while (high - low > 1) {
            int mid;
            if (high + low < 0) {
                mid = (int) (((long) high + (long) low) / 2);
            } else {
                mid = (high + low) / 2;
            }
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        if (isBadVersion(low)) {
            return low;
        } else {
            return high;
        }
    }

    //    External dependency
    protected abstract boolean isBadVersion(int version);
}
