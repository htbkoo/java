package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class NRepeatedElementInSize2NArrayTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new NRepeatedElementInSize2NArray.Solution().repeatedNTimes(A as int[])

        then:
        actual == expected

        where:
        A                        || expected
        [1, 2, 3, 3]             || 3
        [2, 1, 2, 5, 3, 2]       || 2
        [5, 1, 5, 2, 5, 3, 5, 4] || 5
    }
}
