package online.atCoder.beginnerContext114

import spock.lang.Specification
import spock.lang.Unroll

class B754Test extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = B754.process(new B754.TestCase(S))

        then:
        result == expected

        where:
        S            || expected
        "1234567876" || 34
        "35753"      || 0
        "1111111111" || 642
    }

}
