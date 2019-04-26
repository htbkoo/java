package online.hackerrank.interviewPreparationKit.DynamicProgramming

import spock.lang.Specification
import spock.lang.Unroll

class CandiesTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = Candies.Solution.candies(n, arr as int[])

        then:
        actual == expected

        where:
        n  | arr                             || expected
        3  | [1, 2, 2,]                      || 4
        10 | [2, 4, 2, 6, 1, 7, 8, 9, 2, 1,] || 19
        8  | [2, 4, 3, 5, 2, 6, 4, 5,]       || 12
    }
}
