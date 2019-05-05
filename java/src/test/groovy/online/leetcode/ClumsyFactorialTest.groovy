package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class ClumsyFactorialTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new ClumsyFactorial.Solution().clumsy(N)

        then:
        actual == expected

        where:
        N     || expected
        4     || 7
        10    || 12

        1     || 1
        2     || 2
        3     || 6
        5     || 7
        6     || 8
        7     || 6
        8     || 9
        9     || 11
        10000 || 10001
    }
}
