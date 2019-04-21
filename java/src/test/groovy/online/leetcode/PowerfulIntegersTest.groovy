package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class PowerfulIntegersTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = new PowerfulIntegers.Solution().powerfulIntegers(x, y, bound)

        then:
        actual == expected

        where:
        x | y | bound || expected
        2 | 3 | 10    || [2, 3, 4, 5, 7, 9, 10]
        3 | 5 | 15    || [2, 4, 6, 8, 10, 14]
        1 | 1 | 15    || [2]
        2 | 1 | 15    || [2, 3, 5, 9]
    }
}
