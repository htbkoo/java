package online.leetcode

import ArgProvider
import ThreeConsecutiveOdds
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsSource

class ThreeConsecutiveOddsTest {

    @ParameterizedTest
    @ArgumentsSource(ThreeConsecutiveOddsArgProvider::class)
    fun threeConsecutiveOdds(arr: IntArray, expected: Boolean) {
        val actual = ThreeConsecutiveOdds().threeConsecutiveOdds(arr)
        assert(actual == expected) {
            "Expected $expected but got $actual for input ${arr.joinToString(",")}"
        }
    }

    class ThreeConsecutiveOddsArgProvider : ArgProvider(
        arguments(intArrayOf(2, 6, 4, 1), false),
        arguments(intArrayOf(1, 2, 34, 3, 4, 5, 7, 23, 12), true),
    )

}
