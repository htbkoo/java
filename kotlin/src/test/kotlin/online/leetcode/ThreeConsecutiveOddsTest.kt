package online.leetcode

import ArgProvider
import Solution
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsSource

class ThreeConsecutiveOddsTest {

    @ParameterizedTest
    @ArgumentsSource(ThreeConsecutiveOddsArgProvider::class)
    fun threeConsecutiveOdds(arr: List<Int>, expected: Boolean) {
        val actual = Solution().threeConsecutiveOdds(arr.toIntArray())
        assert(actual == expected) {
            "Expected $expected but got $actual for input ${arr.joinToString(",")}"
        }
    }

    class ThreeConsecutiveOddsArgProvider : ArgProvider(
        arguments(listOf(2, 6, 4, 1), false),
        arguments(listOf(1, 2, 34, 3, 4, 5, 7, 23, 12), true),
    )

}
