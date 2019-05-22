package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class ThreeSumTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new ThreeSum.Solution().threeSum(nums as int[])

        then:
        actual == expected

        where:
        nums                                              || expected
        [-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6] || [[-4, -2, 6], [-4, 0, 4], [-4, 1, 3], [-4, 2, 2], [-2, -2, 4], [-2, 0, 2]]
        [-1, 0, 1, 2, -1, -4]                             || [[-1, 0, 1], [-1, -1, 2]]
        [-1, 0, 1, 2, -1, -4, -2]                         || [[-1, 0, 1], [-1, -1, 2], [-2, 0, 2]]
        [-2, -1, 0, 1, 2, -1, -4]                         || [[-1, 0, 1], [-1, -1, 2], [-2, 0, 2]]
    }
}
