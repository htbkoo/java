package online.atCoder.regularContext097

import spock.lang.Specification
import spock.lang.Unroll

class SortedAndSortedTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = SortedAndSorted.process(new SortedAndSorted.TestCase(N, c, a))

        then:
        result == expected

        where:
        N || c                                                                                           || a                                                       || expected
        4 || ["B", "W", "B", "W", "B", "W", "B", "W",]                                                   || [4, 4, 3, 3, 2, 2, 1, 1,]                               || "18"
        3 || ["B", "W", "B", "W", "W", "B",]                                                             || [1, 2, 3, 1, 3, 2,]                                     || "4"
        9 || ["W", "B", "B", "W", "B", "W", "W", "B", "W", "B", "W", "B", "W", "B", "B", "W", "W", "B",] || [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 8, 9, 7, 2, 8, 4, 6, 7,] || "41"
    }
}
