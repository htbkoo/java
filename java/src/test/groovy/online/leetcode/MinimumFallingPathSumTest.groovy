package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class MinimumFallingPathSumTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = new MinimumFallingPathSum.Solution().minFallingPathSum(A as int[][])

        then:
        actual == expected

        where:
        A                                 || expected
        [[51, 24], [-50, 82]]             || -26
        [[1, 2, 3], [4, 5, 6], [7, 8, 9]] || 12
    }
}
