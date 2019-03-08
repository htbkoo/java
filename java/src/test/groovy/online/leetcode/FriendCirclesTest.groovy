package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

abstract class FriendCirclesTestBase extends Specification {
    @Unroll
    def "should find total number of friend circles"() {
        when:
        def num = findCircleNum(M as int[][])

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

    abstract int findCircleNum(int[][] M)
}

class FriendCirclesTest extends FriendCirclesTestBase {
    @Override
    int findCircleNum(int[][] M) {
        new FriendCircles().findCircleNum(M)
    }
}

class FriendCirclesDFSTest extends FriendCirclesTestBase {
    @Override
    int findCircleNum(int[][] M) {
        new FriendCirclesDFS().findCircleNum(M)
    }
}