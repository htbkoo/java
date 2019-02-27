package online.atCoder.beginnerContext119

import spock.lang.Specification
import spock.lang.Unroll

class SyntheticKadomatsuTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = SyntheticKadomatsu.process(new SyntheticKadomatsu.TestCase(N, A, B, C, l))

        then:
        new BigDecimal(result) == new BigDecimal(expected)

        where:
        N || A    || B   || C   || l                                         || expected
        5 || 100  || 90  || 80  || [98, 40, 30, 21, 80,]                     || 23
        8 || 100  || 90  || 80  || [100, 100, 90, 90, 90, 80, 80, 80,]       || 0
        8 || 1000 || 800 || 100 || [300, 333, 400, 444, 500, 555, 600, 666,] || 243
    }
}
