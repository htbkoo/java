package online.atCoder.regularContext101

import spock.lang.Specification
import spock.lang.Unroll

class CandlesTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = Candles.process(new Candles.TestCase(N, K, x))

        then:
        result == expected

        where:
        N || K || x                            || expected
        5 || 3 || [-30, -10, 10, 20, 50]       || 40
        3 || 2 || [10, 20, 30]                 || 20
        1 || 1 || [0]                          || 0
        8 || 5 || [-9, -7, -4, -3, 1, 2, 3, 4] || 10
    }

}
