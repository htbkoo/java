package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class BonAppetitTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = BonAppetit.Solution.testBonAppetit(bill, k, b)

        then:
        actual == expected

        where:
        bill          | k | b  || expected
        [3, 10, 2, 9] | 1 | 12 || "5"
        [3, 10, 2, 9] | 1 | 7  || "Bon Appetit"
    }
}
