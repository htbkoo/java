package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class SortArrayByParityIITest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new SortArrayByParityII.Solution().sortArrayByParityII(A as int[])

        then:
        actual == expected as int[]

        where:
        A            || expected
        [4, 2, 5, 7] || [4, 5, 2, 7]
    }
}
