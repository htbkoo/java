package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class FriendCirclesTest extends Specification {
    @Unroll
    def "should find total number of friend circles"() {
        when:
        def num = new FriendCircles().findCircleNum(M as int[][])

        then:
        num == expected

        where:
        M           || expected
        [[1, 0, 0],
         [0, 1, 0],
         [0, 0, 1]] || 3
        [[1, 1, 0],
         [1, 1, 0],
         [0, 0, 1]] || 2
        [[1, 0, 1],
         [0, 1, 0],
         [1, 0, 1]] || 2
        [[1, 1, 0],
         [1, 1, 1],
         [0, 1, 1]] || 1
    }
}
