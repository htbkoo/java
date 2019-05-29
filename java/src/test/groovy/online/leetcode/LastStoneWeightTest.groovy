package online.leetcode


import spock.lang.Specification
import spock.lang.Unroll

class LastStoneWeightTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = new LastStoneWeight.Solution().lastStoneWeight(stones as int[])

        then:
        actual == expected

        where:
        stones             || expected
        [2, 7, 4, 1, 8, 1] || 1
    }
}
