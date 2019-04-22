package online.hackerrank.interviewPreparationKit.DynamicProgramming

import spock.lang.Specification
import spock.lang.Unroll

class MaxArraySumTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = MaxArraySum.Solution.maxSubsetSum(arr as int[])

        then:
        actual == expected

        where:
        arr               || expected
        [3, 7, 4, 6, 5]   || 13
        [2, 1, 5, 8, 4]   || 11
        [3, 5, -7, 8, 10] || 15
    }
}
