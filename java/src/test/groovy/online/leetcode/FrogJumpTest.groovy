package online.leetcode


import spock.lang.Specification
import spock.lang.Unroll

class FrogJumpTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = new FrogJump.Solution().canCross(stones as int[])

        then:
        actual == expected

        where:
        stones                        || expected
        [0, 1, 3, 4, 5, 7, 9, 10, 12] || true
        [0, 1, 3, 5, 6, 8, 12, 17]    || true
        [0, 1, 2, 3, 4, 8, 9, 11]     || false
        [0, 1, 3, 6, 7]               || false
    }
}
