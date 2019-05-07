package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class SquaresOfASortedArrayTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new SquaresOfASortedArray.Solution().sortedSquares(A as int[])

        then:
        actual == expected as int[]

        where:
        A                  || expected
        [-4, -1, 0, 3, 10] || [0, 1, 9, 16, 100]
        [-7, -3, 2, 3, 11] || [4, 9, 9, 49, 121]
    }
}
