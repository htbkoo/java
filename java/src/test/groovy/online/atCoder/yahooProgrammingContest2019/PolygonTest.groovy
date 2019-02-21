package online.atCoder.yahooProgrammingContest2019

import spock.lang.Specification
import spock.lang.Unroll

class PolygonTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = Polygon.process(new Polygon.TestCase(N, L))

        then:
        result.toString() == expected

        where:
        N  || L                                    || expected
        4  || [3, 8, 5, 1]                         || "Yes"
        4  || [3, 8, 4, 1]                         || "No"
        10 || [1, 8, 10, 5, 8, 12, 34, 100, 11, 3] || "No"
    }
}