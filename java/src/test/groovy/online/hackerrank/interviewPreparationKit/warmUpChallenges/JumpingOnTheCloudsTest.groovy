package online.hackerrank.interviewPreparationKit.warmUpChallenges

import spock.lang.Specification
import spock.lang.Unroll

class JumpingOnTheCloudsTest extends Specification {
    @Unroll
    def "it should print the minimum number of jumps needed to win the game"() {
        when:
        def actual = JumpingOnTheClouds.Solution.jumpingOnClouds(c as int[])

        then:
        actual == expected

        where:
        n || c                     || expected
        7 || [0, 1, 0, 0, 0, 1, 0] || 3
        7 || [0, 0, 1, 0, 0, 1, 0] || 4
        6 || [0, 0, 0, 0, 1, 0]    || 3
    }
}
