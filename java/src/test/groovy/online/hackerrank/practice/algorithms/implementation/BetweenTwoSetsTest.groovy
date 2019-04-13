package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class BetweenTwoSetsTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = BetweenTwoSets.Solution.getTotalX(a as int[], b as int[])

        then:
        actual == expected

        where:
        a      | b            || expected
        [2, 4] | [16, 32, 96] || 3
    }
}
