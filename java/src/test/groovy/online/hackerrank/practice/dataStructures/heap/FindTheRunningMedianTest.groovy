package online.hackerrank.practice.dataStructures.heap

import spock.lang.Specification
import spock.lang.Unroll

class FindTheRunningMedianTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = FindTheRunningMedian.Solution.runningMedian(a as int[])

        then:
        actual == expected as double[]

        where:
        a                   || expected
        [12, 4, 5, 3, 8, 7] || [12.0, 8.0, 5.0, 4.5, 5.0, 6.0]
    }
}
