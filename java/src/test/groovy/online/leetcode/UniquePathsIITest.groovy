package online.leetcode


import spock.lang.Specification
import spock.lang.Unroll

class UniquePathsIITest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = new UniquePathsII.Solution().uniquePathsWithObstacles(obstacleGrid as int[][])

        then:
        actual == expected

        where:
        obstacleGrid || expected
        [[1, 0]]     || 0
        [
                [0, 0, 0],
                [0, 1, 0],
                [0, 0, 0]
        ]            || 2
    }

}
