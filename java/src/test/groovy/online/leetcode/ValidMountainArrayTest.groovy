package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class ValidMountainArrayTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new ValidMountainArray.Solution().validMountainArray(A as int[])

        then:
        actual == expected

        where:
        A            || expected
        [2, 1]       || false
        [3, 5, 5]    || false
        [0, 3, 2, 1] || true
        [0, 3, 4, 1] || true
    }
}
