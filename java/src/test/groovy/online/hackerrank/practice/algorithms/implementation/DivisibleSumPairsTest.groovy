package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class DivisibleSumPairsTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = DivisibleSumPairs.Solution.divisibleSumPairs(n, k, ar as int[])

        then:
        actual == expected

        where:
        n | k | ar                 || expected
        6 | 3 | [1, 3, 2, 6, 1, 2] || 5
    }
}
