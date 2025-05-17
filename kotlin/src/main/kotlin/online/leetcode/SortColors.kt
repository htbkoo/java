import kotlin.math.max

// https://leetcode.com/classic/problems/sort-colors/description/
// 75. Sort Colors

class SortColors {
    fun sortColors(nums: IntArray): Unit {
        var left = 0
        var right = nums.size - 1

        var i = 0

        while (i <= right) {
            if (nums[i] == 0) {
                val temp = nums[left]
                nums[left] = nums[i]
                nums[i] = temp

                left++
                i = max(i, left)
            } else if (nums[i] == 1) {
                i++
            } else if (nums[i] == 2) {
                val temp = nums[right]
                nums[right] = nums[i]
                nums[i] = temp

                right--
            } else {

            }
        }

    }
}
