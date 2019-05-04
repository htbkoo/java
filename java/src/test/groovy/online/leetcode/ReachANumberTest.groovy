package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class ReachANumberTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new ReachANumber.Solution().reachNumber(target)

        then:
        actual == expected

        where:
        target  || expected
        2       || 3
        3       || 2

        1034083 || 1438

    }
}
