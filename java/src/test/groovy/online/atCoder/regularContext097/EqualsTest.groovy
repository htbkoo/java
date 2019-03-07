package online.atCoder.regularContext097

import spock.lang.Specification
import spock.lang.Unroll

class EqualsTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = Equals.process(new Equals.TestCase(N, M, p, x, y))

        then:
        result == expected

        where:
        N  || M || p                               || x                         || y                         || expected
        10 || 8 || [5, 3, 6, 8, 7, 10, 9, 1, 2, 4] || [3, 4, 5, 2, 6, 3, 8, 7,] || [1, 1, 9, 5, 5, 5, 9, 9,] || "8"
        5  || 2 || [5, 3, 1, 4, 2]                 || [1, 5,]                   || [3, 4,]                   || "2"
        3  || 2 || [3, 2, 1]                       || [1, 2,]                   || [2, 3,]                   || "3"
        5  || 1 || [1, 2, 3, 4, 5]                 || [1]                       || [5]                       || "5"
    }
}
