package online.hackerrank.interviewPreparationKit.GreedyAlgorithms

import spock.lang.Specification
import spock.lang.Unroll

class MaxMinTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = GreedyFlorist.Solution.maxMin(k, arr as int[])

        then:
        actual == expected

        where:
        k | arr                                    || expected
        3 | [10, 100, 300, 200, 1000, 20, 30,]     || 20
        4 | [1, 2, 3, 4, 10, 20, 30, 40, 100, 200] || 3
        2 | [1, 2, 1, 2, 1,]                       || 0
    }

}
