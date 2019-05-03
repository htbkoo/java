package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class SequenceEquationTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = SequenceEquation.Solution.permutationEquation(p as int[])

        then:
        actual == expected as int[]

        where:
        p               || expected
        [2, 3, 1]       || [2, 3, 1]
        [4, 3, 5, 1, 2] || [1, 3, 5, 4, 2]
    }
}
