package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class JumpingOnTheCloudsRevisitedTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = JumpingOnTheCloudsRevisited.Solution.jumpingOnClouds(c as int[], k)

        then:
        actual == expected

        where:
        c                              | k || expected
        [0, 0, 1, 0, 0, 1, 1, 0]       | 2 || 92
        [0, 0, 1, 0]                   | 2 || 96
        [1, 1, 1, 0, 1, 1, 0, 0, 0, 0] | 3 || 94

    }
}
