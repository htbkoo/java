package online.hackerrank.interviewPreparationKit.Arrays

import spock.lang.Specification
import spock.lang.Unroll

class LeftRotationTest extends Specification {
    @Unroll
    def "it should print a single line of n space-separated integers denoting the final state of the array after performing d left rotations"() {
        when:
        def actual = LeftRotation.Solution.rotLeft(a as int[], d)

        then:
        actual == expected as int[]

        where:
        a               || d || expected
        [1, 2, 3, 4, 5] || 5 || [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5] || 4 || [5, 1, 2, 3, 4]
        [1, 2, 3, 4, 5] || 3 || [4, 5, 1, 2, 3]
        [1, 2, 3, 4, 5] || 2 || [3, 4, 5, 1, 2]
        [1, 2, 3, 4, 5] || 1 || [2, 3, 4, 5, 1]
    }
}
