package online.atCoder.grandContext030

import spock.lang.Specification
import spock.lang.Unroll

class PoisonousCookiesTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = PoisonousCookies.process(new PoisonousCookies.TestCase(A, B, C))

        then:
        new BigDecimal(result) == new BigDecimal(expected)

        where:
        A || B || C || expected
        3 || 1 || 4 || 5
        5 || 2 || 9 || 10
        8 || 8 || 1 || 9
    }

}
