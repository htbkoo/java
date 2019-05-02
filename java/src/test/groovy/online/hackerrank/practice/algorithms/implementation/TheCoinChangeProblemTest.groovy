package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class TheCoinChangeProblemTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = TheCoinChangeProblem.Solution.getWays(n, c as long[])

        then:
        actual == expected

        where:
        n  | c            || expected
        4  | [1, 2, 3]    || 4
        10 | [2, 5, 3, 6] || 5
    }
}
