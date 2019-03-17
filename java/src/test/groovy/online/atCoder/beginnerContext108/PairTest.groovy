package online.atCoder.beginnerContext108

import spock.lang.Specification
import spock.lang.Unroll

class PairTest extends Specification {
    @Unroll
    def "test"() {
        when:
        def actual = Pair.process(K)

        then:
        actual == expected

        where:
        K  || expected
        3  || "2"
        6  || "9"
        7  || "12"
        11 || "30"
        50 || "625"
    }
}
