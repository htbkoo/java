package online.leetcode


import spock.lang.Specification
import spock.lang.Unroll

class HeightCheckerTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = new HeightChecker.Solution().heightChecker(heights as int[])

        then:
        actual == expected

        where:
        heights               || expected
        [1, 1, 4, 2, 1, 3]    || 3
        [7, 1, 2, 3, 4, 5, 6] || 7
    }
}
