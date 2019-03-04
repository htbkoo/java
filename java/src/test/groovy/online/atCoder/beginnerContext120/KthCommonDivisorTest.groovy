package online.atCoder.beginnerContext120

import spock.lang.Specification
import spock.lang.Unroll

class KthCommonDivisorTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = KthCommonDivisor.process(new KthCommonDivisor.TestCase(A, B, K))

        then:
        result == expected

        where:
        A   || B  || K || expected
        100 || 50 || 4 || "5"
        8   || 12 || 2 || "2"
        1   || 1  || 1 || "1"
    }

}
