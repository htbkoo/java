package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class CatsAndAMouseTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = CatsAndAMouse.Solution.catAndMouse(x, y, z)

        then:
        actual == expected

        where:
        x | y | z || expected
        2 | 1 | 3 || "Cat A"
        1 | 2 | 3 || "Cat B"
        1 | 3 | 2 || "Mouse C"
    }
}
