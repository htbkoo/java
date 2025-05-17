package online.leetcode

import ArgProvider
import SortColors
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsSource

class SortColorsTest {

    @ParameterizedTest
    @ArgumentsSource(SortColorsArgProvider::class)
    fun sortColors(nums: IntArray, expected: IntArray) {
        val sourceNums = nums.copyOf()
        SortColors().sortColors(nums)
        assert(nums.contentEquals(expected)) {
            "Expected $expected but got $nums for input ${sourceNums.joinToString(",")}"
        }
    }

    class SortColorsArgProvider : ArgProvider(
        arguments(intArrayOf(2, 0, 2, 1, 1, 0), intArrayOf(0, 0, 1, 1, 2, 2)),
        arguments(intArrayOf(2, 0, 1), intArrayOf(0, 1, 2)),
        arguments(intArrayOf(0), intArrayOf(0)),
    )

}
