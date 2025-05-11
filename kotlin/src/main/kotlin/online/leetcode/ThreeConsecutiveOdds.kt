// https://leetcode.com/classic/problems/three-consecutive-odds/description/
// 1550. Three Consecutive Odds

class Solution {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var i = 2
        while (i < arr.size) {
            if (arr[i - 2] % 2 != 0 && arr[i - 1] % 2 != 0 && arr[i] % 2 != 0) {
                return true
            }

            i++
        }
        return false
    }
}
