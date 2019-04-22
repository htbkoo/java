package online.hackerrank.interviewPreparationKit.GreedyAlgorithms


import spock.lang.Specification
import spock.lang.Unroll

class MinimumAbsoluteDifferenceInAnArrayTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = MinimumAbsoluteDifferenceInAnArray.Solution.minimumAbsoluteDifference(arr as int[])

        then:
        actual == expected

        where:
        arr                                            || expected
        [3, -7, 0]                                     || 3
        [-59, -36, -13, 1, -53, -92, -2, -96, -54, 75] || 1
        [1, -3, 71, 68, 17]                            || 3
    }

}
