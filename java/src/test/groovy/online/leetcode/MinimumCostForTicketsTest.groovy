package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class MinimumCostForTicketsTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = new MinimumCostForTickets.Solution().mincostTickets(days as int[], costs as int[],)

        then:
        actual == expected

        where:
        days                                    | costs      || expected
        [1, 4, 6, 7, 8, 20]                     | [2, 7, 15] || 11
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31] | [2, 7, 15] || 17
    }
}
