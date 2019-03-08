package online.atCoder.beginnerContext109

import spock.lang.Specification
import spock.lang.Unroll

class SkipTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = Skip.process(new Skip.TestCase(N, X, x))

        then:
        result == expected

        where:
        N || X  || x             || expected
        3 || 3  || [1, 7, 11]    || "2"
        3 || 81 || [33, 105, 57] || "24"
        1 || 1  || [1000000000]  || "999999999"
    }
}
