package online.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class SumOfEvenNumbersAfterQueriesTest extends Specification {

    @Unroll
    def "test"() {
        when:
        def actual = new SumOfEvenNumbersAfterQueries.Solution().sumEvenAfterQueries(A as int[], queries as int[][])

        then:
        actual == expected as int[]

        where:
        A            | queries                            || expected
        [1, 2, 3, 4] | [[1, 0], [-3, 1], [-4, 0], [2, 3]] || [8, 6, 2, 4]
    }
}
