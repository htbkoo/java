package online.hackerrank.interviewPreparationKit.Miscellaneous

import spock.lang.Specification
import spock.lang.Unroll

class FriendCircleQueriesTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = FriendCircleQueries.Solution.maxCircle(queries as int[][])

        then:
        actual == expected as int[]

        where:
        queries             || expected
        [[1, 2],
         [3, 4],
         [1, 3],
         [5, 7],
         [5, 6],
         [7, 4],]           || [2, 2, 4, 4, 4, 7]
        [[1, 2],
         [3, 4],
         [2, 3],]           || [2, 2, 4]
        [[1, 2],
         [1, 3],]           || [2, 3]
        [[1000000000, 23],
         [11, 3778],
         [7, 47],
         [11, 1000000000],] || [2, 2, 2, 4]
    }
}
