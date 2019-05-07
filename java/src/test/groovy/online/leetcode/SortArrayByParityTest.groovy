package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class SortArrayByParityTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new SortArrayByParity.Solution().sortArrayByParity(A as int[])

        then:
        actual == expected as int[]

        where:
        A            || expected
        [3, 1, 2, 4] || [2, 4, 3, 1]
    }
}
