package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class MinCostClimbingStairsTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new MinCostClimbingStairs.Solution().minCostClimbingStairs(cost as int[])

        then:
        actual == expected

        where:
        cost                                 || expected
        [0, 0, 0, 0]                         || 0
        [10, 15, 20]                         || 15
        [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] || 6
    }
}
