package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class ClimbingTheLeaderboardTest extends Specification {
    @Unroll
    def "should return the total number of matching pairs of socks that John can sell"() {
        when:
        def actual = ClimbingTheLeaderboard.Solution.climbingLeaderboard(scores as int[], alice as int[])

        then:
        actual == expected as int[]

        where:
        scores                         | alice                 || expected
        [100, 100, 50, 40, 40, 20, 10] | [5, 25, 50, 120]      || [6, 4, 2, 1]
        [100, 90, 90, 80, 75, 60]      | [50, 65, 77, 90, 102] || [6, 5, 4, 2, 1]
    }
}
