package online.atCoder.beginnerContext115

import spock.lang.Specification
import spock.lang.Unroll

class ChristmasEveTest extends Specification {

    @Unroll
    def "should find"() {
        when:
        def result = ChristmasEve.process(new ChristmasEve.TestCase(N, K, h))

        then:
        result == expected

        where:
        N || K || h                    || expected
        5 || 3 || [10, 15, 11, 14, 12] || 2
        5 || 3 || [5, 7, 5, 7, 7]      || 0
    }

}
