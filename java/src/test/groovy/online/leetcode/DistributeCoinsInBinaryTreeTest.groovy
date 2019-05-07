package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class DistributeCoinsInBinaryTreeTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new DIStringMatch.Solution().diStringMatch(S)

        then:
        actual == expected as int[]

        where:
        S      || expected
        "IDID" || [0, 4, 1, 3, 2]
        "III"  || [0, 1, 2, 3]
        "DDI"  || [3, 2, 0, 1]
    }
}
