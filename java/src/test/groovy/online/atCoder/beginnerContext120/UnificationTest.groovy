package online.atCoder.beginnerContext120

import spock.lang.Specification
import spock.lang.Unroll

class UnificationTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = Unification.process(new Unification.TestCase(S))

        then:
        result == expected

        where:
        S                || expected
        "0011"           || "4"
        "11011010001011" || "12"
        "0"              || "0"
    }

}
