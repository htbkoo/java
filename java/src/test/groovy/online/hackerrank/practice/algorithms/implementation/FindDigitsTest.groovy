package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class FindDigitsTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = FindDigits.Solution.findDigits(n)

        then:
        actual == expected

        where:
        n    || expected
        111  || 3

        12   || 2
        1012 || 3
    }
}
