package online.hackerrank.interviewPreparationKit.GreedyAlgorithms

import spock.lang.Specification
import spock.lang.Unroll

class GreedyFloristTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = GreedyFlorist.Solution.getMinimumCost(k, c as int[])

        then:
        actual == expected

        where:
        k | c               || expected
        3 | [2, 5, 6]       || 13
        2 | [2, 5, 6]       || 15
        3 | [1, 3, 5, 7, 9] || 29
    }

}
