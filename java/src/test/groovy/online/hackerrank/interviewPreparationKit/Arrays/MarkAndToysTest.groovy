package online.hackerrank.interviewPreparationKit.Arrays

import spock.lang.Specification
import spock.lang.Unroll

class MarkAndToysTest extends Specification {
    @Unroll
    def "It should return an integer representing the maximum number of toys Mark can purchase"() {
        when:
        def actual = MarkAndToys.Solution.maximumToys(prices as int[], k)

        then:
        actual == expected

        where:
        prices                         || k  || expected
        [1, 12, 5, 111, 200, 1000, 10] || 50 || 4
        [1, 2, 3, 4]                   || 7  || 3
    }
}
