package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class MinimumPathSumTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = new MinimumPathSum.Solution().minPathSum(grid as int[][])

        then:
        actual == expected

        where:
        grid || expected
        [
                [1, 3, 1],
                [1, 5, 1],
                [4, 2, 1]
        ]    || 7
    }
}
