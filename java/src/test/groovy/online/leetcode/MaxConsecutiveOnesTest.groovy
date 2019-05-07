package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class MaxConsecutiveOnesTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new MaxConsecutiveOnes.Solution().findMaxConsecutiveOnes(nums as int[])

        then:
        actual == expected

        where:
        nums                     || expected
        [1, 1, 0, 1, 1, 1]       || 3
        [1, 0, 1, 1, 0, 1, 0, 1] || 2
    }
}
