package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class CircularArrayRotationTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = CircularArrayRotation.Solution.circularArrayRotation(a as int[], k, queries as int[])

        then:
        actual == expected as int[]

        where:
        a               | k     | queries         || expected
        [1, 2, 3]       | 2     | [0, 1, 2]       || [2, 3, 1]
        [1, 2, 3]       | 1     | [0, 1, 2]       || [3, 1, 2]
        [1, 2, 3]       | 0     | [0, 1, 2]       || [1, 2, 3]

        [1, 2, 3, 4, 5] | 3     | [0, 1, 2, 3, 4] || [3, 4, 5, 1, 2]
        [1, 2, 3, 4, 5] | 10000 | [0, 1, 2, 3, 4] || [1, 2, 3, 4, 5]
    }
}
