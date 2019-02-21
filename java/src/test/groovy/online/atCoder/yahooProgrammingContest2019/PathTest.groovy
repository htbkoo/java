package online.atCoder.yahooProgrammingContest2019

import spock.lang.Specification
import spock.lang.Unroll

class PathTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = Path.process(new Path.TestCase(roads))

        then:
        result == expected

        where:
        roads                     || expected
        [[4, 2], [1, 3], [2, 3],] || "YES"
        [[3, 2], [2, 4], [1, 2],] || "NO"
        [[2, 1], [3, 2], [4, 3],] || "YES"
    }
}