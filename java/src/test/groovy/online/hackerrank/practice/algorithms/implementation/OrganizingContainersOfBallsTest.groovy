package online.hackerrank.practice.algorithms.implementation

import spock.lang.Specification
import spock.lang.Unroll

class OrganizingContainersOfBallsTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = OrganizingContainersOfBalls.Solution.organizingContainers(container as int[][])

        then:
        actual == expected

        where:
        container    || expected
        [[1, 1],
         [1, 1],]    || "Possible"
        [[0, 2],
         [1, 1],]    || "Impossible"

        [[1, 3, 1],
         [2, 1, 2],
         [3, 3, 3],] || "Impossible"
        [[0, 2, 1],
         [1, 1, 1],
         [2, 0, 0],] || "Possible"
    }
}
