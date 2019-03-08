package online.atCoder.beginnerContext109

import spock.lang.Specification
import spock.lang.Unroll

class ABC333Test extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = ABC333.process(new ABC333.TestCase(A, B))

        then:
        result == expected

        where:
        A || B || expected
        3 || 1 || "Yes"
        1 || 2 || "No"
        2 || 2 || "No"
    }
}
