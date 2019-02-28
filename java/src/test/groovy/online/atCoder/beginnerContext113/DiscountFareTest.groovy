package online.atCoder.beginnerContext113

import spock.lang.Specification
import spock.lang.Unroll

class DiscountFareTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = DiscountFare.process(new DiscountFare.TestCase(X, Y))

        then:
        result == expected

        where:
        X  || Y || expected
        81 || 58 | 110
        4  || 54 | 31
    }

}
