package online.atCoder.yahooProgrammingContest2019

import spock.lang.Specification
import spock.lang.Unroll

class AntiAdjacencyTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = AntiAdjacency.process(new AntiAdjacency.TestCase(N, K))

        then:
        result == expected

        where:
        N  || K  || expected
        3  || 2  || "YES"
        31 || 10 || "YES"
        5  || 1  || "YES"
        5  || 2  || "YES"
        5  || 3  || "YES"
        5  || 4  || "NO"
        5  || 5  || "NO"
        5  || 6  || "NO"
        10 || 90 || "NO"
    }
}