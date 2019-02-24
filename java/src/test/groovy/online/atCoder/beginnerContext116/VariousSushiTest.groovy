package online.atCoder.beginnerContext116

import spock.lang.Specification
import spock.lang.Unroll

class VariousSushiTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = VariousSushi.process(new VariousSushi.TestCase(N, K, t, d))

        then:
        result == expected

        where:
        N || K || t                      || d                                                                    || expected
        5 || 3 || [1, 1, 2, 2, 3,]       || [9, 7, 6, 5, 1,]                                                     || 26L
        7 || 4 || [1, 2, 3, 4, 4, 4, 4,] || [1, 1, 1, 6, 5, 5, 5,]                                               || 25L
        6 || 5 || [5, 2, 3, 6, 6, 4,]    || [1000000000, 990000000, 980000000, 970000000, 960000000, 950000000,] || 4900000016L
    }
}