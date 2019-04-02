package online.hackerrank.interviewPreparationKit.warmUpChallenges

import online.hackerrank.interviewPreparationKit.RecursionAndBacktracking.RecursionFibonacciNumbers
import spock.lang.Specification
import spock.lang.Unroll

class RecursionFibonacciNumbersTest extends Specification {

    @Unroll
    def "It tests"() {
        when:
        def actual = RecursionFibonacciNumbers.Solution.fibonacci(n)

        then:
        actual == expected

        where:
        n  || expected
        0  || 0
        1  || 1
        2  || 1
        3  || 2
        4  || 3
        5  || 5
        6  || 8
        20 || 6765
    }

}
