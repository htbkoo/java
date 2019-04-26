package online.atCoder.beginnerContext124

import spock.lang.Specification
import spock.lang.Unroll

class ButtonsTest extends Specification {
    @Unroll
    def "should find"() {
        when:
        def result = Buttons.process(A, B)

        then:
        result == expected

        where:
        A | B || expected
        5 | 3 || "9"
        3 | 4 || "7"
        6 | 6 || "12"
    }
}
