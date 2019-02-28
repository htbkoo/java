package online.atCoder.beginnerContext114

import spock.lang.Specification
import spock.lang.Unroll

class A753Test extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = A753.process(new A753.TestCase(X))

        then:
        result == expected

        where:
        X || expected
        5 || "YES"
        6 || "NO"
    }

}
