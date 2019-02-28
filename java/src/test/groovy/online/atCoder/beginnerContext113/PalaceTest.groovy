package online.atCoder.beginnerContext113

import spock.lang.Specification
import spock.lang.Unroll

class PalaceTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = Palace.process(new Palace.TestCase(N, T, A, H))

        then:
        result == expected

        where:
        N || T  || A   || H                     || expected
        2 || 12 || 5   || [1000, 2000]          || 1
        3 || 21 || -11 || [81234, 94124, 52141] || 3
    }

}
