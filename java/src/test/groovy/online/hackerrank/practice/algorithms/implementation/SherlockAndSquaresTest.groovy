package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class SherlockAndSquaresTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = SherlockAndSquares.Solution.squares(a, b)

        then:
        actual == expected

        where:
        a  | b  || expected
        1  | 49 || 7
        1  | 1  || 1
        1  | 2  || 1
        1  | 3  || 1
        1  | 4  || 2
        1  | 5  || 2
        1  | 6  || 2
        1  | 7  || 2
        1  | 8  || 2
        1  | 9  || 3

        15 | 49 || 4
        16 | 49 || 4
        17 | 49 || 3

        24 | 49 || 3

        3  | 9  || 2
        17 | 24 || 0
    }
}
