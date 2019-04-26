package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class FindTheTownJudgeTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def num = new FindTheTownJudge.Solution().findJudge(N, trust as int[][])

        then:
        num == expected

        where:
        N | trust                                    || expected
        2 | [[1, 2]]                                 || 2
        3 | [[1, 3], [2, 3]]                         || 3
        3 | [[1, 3], [2, 3], [3, 1]]                 || -1
        3 | [[1, 2], [2, 3]]                         || -1
        4 | [[1, 3], [1, 4], [2, 3], [2, 4], [4, 3]] || 3
    }
}
