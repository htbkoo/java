package online.atCoder.yahooProgrammingContest2019

import spock.lang.Specification
import spock.lang.Unroll

class WhenIHitMyPocketTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = WhenIHitMyPocket.process(new WhenIHitMyPocket.TestCase(K, A, B))

        then:
        result == expected

        where:
        K         || A        || B         || expected
        4         || 2        || 6         || 7
        7         || 3         | 4         || 8
        1         || 1         | 1         || 2
        2         || 1         | 1         || 3
        2         || 1         | 10        || 10
        314159265 || 35897932 || 384626433 || 48518828981938099
    }
}