package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class CherryPickupTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = new CherryPickup.Solution().cherryPickup(grid as int[][])

        then:
        actual == expected

        where:
        grid                    || expected
        [[1, 1, 1, 1, 0, 0, 0],
         [0, 0, 0, 1, 0, 0, 0],
         [0, 0, 0, 1, 0, 0, 1],
         [1, 0, 0, 1, 0, 0, 0],
         [0, 0, 0, 1, 0, 0, 0],
         [0, 0, 0, 1, 0, 0, 0],
         [0, 0, 0, 1, 1, 1, 1]] || 15
        [[1]]                   || 1
        [[0, 1, -1],
         [1, 0, -1],
         [1, 1, 1]]             || 5
    }
}
