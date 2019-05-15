package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class SmallestRangeITest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new SmallestRangeI.Solution().smallestRangeI(A as int[], K)

        then:
        actual == expected

        where:
        A         | K || expected
        [1]       | 0 || 0
        [0, 10]   | 2 || 6
        [1, 3, 6] | 3 || 0
    }
}
