package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class BreakingTheRecordsTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = BreakingTheRecords.Solution.breakingRecords(scores as int[])

        then:
        actual == expected as int[]

        where:
        scores                                || expected
        [10, 5, 20, 20, 4, 5, 2, 25, 1]       || [2, 4]
        [3, 4, 21, 36, 10, 28, 35, 5, 24, 42] || [4, 0]
    }
}
