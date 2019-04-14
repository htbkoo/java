package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class ThreeDSurfaceAreaTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = ThreeDSurfaceArea.Solution.surfaceArea(A as int[][])

        then:
        actual == expected

        where:
        A     || expected
        [
                [1, 3, 4],
                [2, 2, 3],
                [1, 2, 4],
        ]     || 60
        [[1]] || 6
    }
}
