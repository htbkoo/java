package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class TheHurdleRaceTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = TheHurdleRace.Solution.hurdleRace(k, height as int[])

        then:
        actual == expected

        where:
        k | height          || expected
        1 | [1, 2, 3, 3, 2] || 2
        4 | [1, 6, 3, 5, 2] || 2
        5 | [2, 5, 4, 5, 2] || 0
    }
}
